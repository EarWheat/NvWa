package com.nvwa.registry.service;


import com.alibaba.fastjson.JSONObject;
import com.nvwa.registry.annotation.ServiceProvider;
import com.nvwa.registry.cache.ProviderContainer;
import com.nvwa.registry.domain.NetUrl;
import com.nvwa.registry.domain.ProviderRegistryEntity;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
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
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc: 服务注册
 * @Author: 泽露
 * @Date: 2022/7/6 7:44 PM
 * @Version: 1.initial version; 2022/7/6 7:44 PM
 */
@Component
@Slf4j
public class ServerProviderRegistry implements InitializingBean, ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(ServerProviderRegistry.class);

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private ApplicationContext applicationContext;
    public static final int PORT = 8090;

    private static ConcurrentHashMap<String, Object> serviceBeanMap = new ConcurrentHashMap<>();

    private ByteBuffer buffer;

    /**
     * 绑定端口
     * @throws IOException
     */
    public ServerProviderRegistry() throws IOException {
        this.selector = Selector.open();
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", PORT);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(socketAddress);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        buffer = ByteBuffer.allocate(1024);
    }



    /**
     * 注册
     * @param service
     */
    public void registry(Class<?> service) throws IOException {
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
        logger.trace("开始扫描ServiceProvider的实现类并注册");
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(ServiceProvider.class);
        beansWithAnnotation.forEach((key, value) -> {
            ServiceProvider registryServer = value.getClass().getAnnotation(ServiceProvider.class);
            Class<?> service = registryServer.serviceInterface();
            try {
                registry(service);
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
