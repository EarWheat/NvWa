package com.nvwa;

import com.nvwa.registry.annotation.EnableRegistryServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：liuzhaolu
 * @description：eureka
 * @prd :
 * @date ：2021/12/21 11:30 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/21 11:30 上午     liuzhaolu       firstVersion
 */
@Slf4j
@SpringBootApplication
@EnableRegistryServer
@ComponentScan(value = "com.nvwa")
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServerApplication.class);
        application.run(args);
        log.info("ServerApplication started");
    }
}
