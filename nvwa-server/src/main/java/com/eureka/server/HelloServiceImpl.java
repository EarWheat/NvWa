package com.eureka.server;

import com.nvwa.registry.annotation.RegistryServer;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/7 6:26 PM
 * @Version: 1.initial version; 2022/7/7 6:26 PM
 */
@RegistryServer(service = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String hi) {
        return "hi" + hi;
    }
}
