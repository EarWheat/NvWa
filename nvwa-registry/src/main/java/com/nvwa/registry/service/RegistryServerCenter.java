package com.nvwa.registry.service;


import com.alibaba.fastjson.JSONObject;
import com.nvwa.registry.annotation.RegistryServer;
import com.nvwa.registry.cache.ProviderContainer;
import com.nvwa.registry.domain.NetUrl;
import com.nvwa.registry.domain.ProviderRegistryEntity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/6 7:44 PM
 * @Version: 1.initial version; 2022/7/6 7:44 PM
 */
@Component
public class RegistryServerCenter implements SmartLifecycle, InitializingBean, ApplicationContextAware {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private ApplicationContext applicationContext;
    public static final int PORT = 8090;

    private ByteBuffer buffer;

    public RegistryServerCenter() throws IOException {
        this.selector = Selector.open();
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", PORT);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(socketAddress);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        buffer = ByteBuffer.allocate(1024);
    }

    @Override
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    try {
                        selector.select();
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            if (key.isAcceptable()) {
                                SocketChannel accept = serverSocketChannel.accept();
                                accept.configureBlocking(false);
                                accept.register(selector, SelectionKey.OP_READ);
                            } else if (key.isReadable()) {
                                SocketChannel channel = (SocketChannel) key.channel();
                                key.interestOps(SelectionKey.OP_WRITE);
                                handleRegistrySocket(channel);
                            } else if (key.isWritable()) {
                                SocketChannel channel = (SocketChannel) key.channel();

                            }
                            iterator.remove();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    /**
     * 处理注册链接
     * @param channel
     */
    public void handleRegistrySocket(SocketChannel channel){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            byteBuffer.clear();
            channel.read(byteBuffer);
            byteBuffer.flip();
            String s = new String(byteBuffer.array(), StandardCharsets.UTF_8);
            ProviderRegistryEntity providerRegistry = JSONObject.parseObject(s, ProviderRegistryEntity.class);
            System.out.println("received:" + JSONObject.toJSONString(providerRegistry));
            ProviderContainer.registry(providerRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            byteBuffer.clear();
        }
    }


    /**
     * 注册
     * @param service
     * @param netUrl
     */
    public void registry(Class<?> service, NetUrl netUrl) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", PORT));
            // 写入数据
            String canonicalName = service.getCanonicalName();
            Method[] declaredMethods = service.getDeclaredMethods();
            SocketChannel finalSocketChannel = socketChannel;
            Arrays.stream(declaredMethods).forEach(method -> {
                ProviderRegistryEntity provider = ProviderRegistryEntity.builder()
                        .name(canonicalName)
                        .method(method)
                        .build();
                byteBuffer.put(JSONObject.toJSONString(provider).getBytes(StandardCharsets.UTF_8));
                byteBuffer.flip();
                try {
                    finalSocketChannel.write(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            byteBuffer.clear();
            if(Objects.nonNull(socketChannel)){
                socketChannel.close();
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RegistryServer.class);
        beansWithAnnotation.forEach((key, value) -> {
            RegistryServer registryServer = value.getClass().getAnnotation(RegistryServer.class);
            Class<?> service = registryServer.service();
            try {
                registry(service, NetUrl.getRegistryUrl());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
