package com.nvwa.remote.serviceImpl;


import com.nvwa.remote.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author ：liuzhaolu
 * @description：hello
 * @prd :
 * @date ：2021/12/21 4:46 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/21 4:46 下午     liuzhaolu       firstVersion
 */
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "liuzhaolu";
    }
}
