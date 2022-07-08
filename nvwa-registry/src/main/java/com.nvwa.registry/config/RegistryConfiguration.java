package com.nvwa.registry.config;

import com.nvwa.registry.service.RegistryServerCenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc: 注册中心
 * @Author: 泽露
 * @Date: 2022/7/6 7:38 PM
 * @Version: 1.initial version; 2022/7/6 7:38 PM
 */
@Configuration
public class RegistryConfiguration {

    @Bean
    public RegistryServerCenter registryServerCenter(){
        RegistryServerCenter server = null;
        try {
            server = new RegistryServerCenter();
        } catch (Exception e){

        }
        return server;
    };

}
