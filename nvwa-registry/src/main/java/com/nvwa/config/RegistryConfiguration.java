package com.nvwa.config;

import com.nvwa.service.RegistryCenter;
import org.springframework.context.annotation.Bean;

/**
 * @Desc: 注册中心
 * @Author: 泽露
 * @Date: 2022/7/6 7:38 PM
 * @Version: 1.initial version; 2022/7/6 7:38 PM
 */
public class RegistryConfiguration {

    @Bean
    public RegistryCenter registryCenter(){
        RegistryCenter server = null;
        try {
            server = new RegistryCenter();
        } catch (Exception e){

        }
        return server;
    };

}
