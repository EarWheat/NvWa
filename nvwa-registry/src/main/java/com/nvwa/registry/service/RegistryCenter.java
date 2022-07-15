package com.nvwa.registry.service;

import com.alibaba.fastjson.JSONObject;
import com.nvwa.registry.cache.ProviderContainer;
import com.nvwa.registry.domain.ProviderRegistryEntity;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc: 注册中心
 * @Author: 泽露
 * @Date: 2022/7/14 8:02 PM
 * @Version: 1.initial version; 2022/7/14 8:02 PM
 */
public class RegistryCenter implements SmartLifecycle, InitializingBean, ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(RegistryCenter.class);

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private ApplicationContext applicationContext;

    @Value("${registry.server.host:127.0.0.1}")
    private String HOST;

    @Value("${registry.server.port:9000}")
    public Integer PORT;

    private static ConcurrentHashMap<String, Object> serviceBeanMap = new ConcurrentHashMap<>();

    private ByteBuffer buffer;

    /**
     * 绑定端口
     * @throws IOException
     */
    public RegistryCenter() throws IOException {
        this.selector = Selector.open();
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress(HOST, PORT);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(socketAddress);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        buffer = ByteBuffer.allocate(1024);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
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

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
