package com.nvwa.serviceImpl;

import com.nvwa.service.DubboDemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author ：liuzhaolu
 * @description：dubbo服务demo实现类
 * @prd :
 * @date ：2022/1/11 5:19 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/11 5:19 下午     liuzhaolu       firstVersion
 */
@DubboService
@Component
public class DubboDemoServiceImpl implements DubboDemoService {

    @Override
    public String helloDubbo(String name) {
        return "hello " + name + "! from dubbo";
    }
}
