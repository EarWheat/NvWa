package com.cookie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc: 任务控制类
 * @Author: 泽露
 * @Date: 2022/11/11 8:24 PM
 * @Version: 1.initial version; 2022/11/11 8:24 PM
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {


    @RequestMapping(value = "/getTask")
    public String getTask() {
        return "task empty";
    }
}
