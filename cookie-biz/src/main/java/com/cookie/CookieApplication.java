package com.cookie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Desc: 芝士饼干小游戏服务端
 * @Author: 泽露
 * @Date: 2022/11/11 8:17 PM
 * @Version: 1.initial version; 2022/11/11 8:17 PM
 */
@SpringBootApplication
@Slf4j
public class CookieApplication extends SpringApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CookieApplication.class);
        application.run(args);
        log.info("CookieApplication start success...");
    }
}
