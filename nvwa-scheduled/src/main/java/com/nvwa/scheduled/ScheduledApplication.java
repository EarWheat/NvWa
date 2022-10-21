package com.nvwa.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/21 3:41 PM
 * @Version: 1.initial version; 2022/10/21 3:41 PM
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
@EnableDubbo
public class ScheduledApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ScheduledApplication.class);
        application.run(args);
        log.info("ScheduledApplication start success...");
    }
}
