package com.nvwa.remote;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ：liuzhaolu
 * @description：Nvwa远程模块
 * @prd :
 * @date ：2022/1/17 8:02 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 8:02 下午     liuzhaolu       firstVersion
 */
@SpringBootApplication
@Slf4j
@EnableDubbo
@ComponentScan(value = "com.nvwa.remote")
@EnableAutoConfiguration
@ImportResource(locations = "classpath:dubboConfig.xml")
public class RemoteApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RemoteApplication.class);
        application.run(args);
        log.info("RemoteApplication start success!");
    }
}
