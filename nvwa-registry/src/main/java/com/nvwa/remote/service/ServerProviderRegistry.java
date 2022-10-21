package com.nvwa.remote.service;


import com.alibaba.fastjson.JSONObject;
import com.nvwa.remote.annotation.ServiceProvider;
import com.nvwa.remote.domain.ProviderRegistryEntity;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
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
//@Slf4j
public class ServerProviderRegistry implements InitializingBean, ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(ServerProviderRegistry.class);

    private ApplicationContext applicationContext;

    @Value("${registry.server.host:127.0.0.1}")
    private String HOST;

    @Value("${registry.server.port:9000}")
    public Integer PORT;

    private static ConcurrentHashMap<String, Object> serviceBeanMap = new ConcurrentHashMap<>();


    /**
     * 注册
     * @param service
     */
    public void registry(Class<?> service) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10240000);
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
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
