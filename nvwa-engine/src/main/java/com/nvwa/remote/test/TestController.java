package com.nvwa.remote.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liuzhaolu
 * @description：测试controller
 * @prd :
 * @date ：2021/12/21 2:43 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/21 2:43 下午     liuzhaolu       firstVersion
 */
@RestController
@RequestMapping("/com/nvwa/api/test")
public class TestController {

    @RequestMapping("/")
    public JSONObject test(){
        JSONObject result = new JSONObject();
        result.put("Hello","eureka");
        return result;
    }

}
