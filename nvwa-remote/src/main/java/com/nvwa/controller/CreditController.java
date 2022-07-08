package com.nvwa.controller;

import com.alibaba.fastjson.JSONObject;
import com.nvwa.response.CreditInfo;
import com.nvwa.response.OrderInfo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liuzhaolu
 * @description：分系统
 * @prd :
 * @date ：2022/3/25 4:34 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/25 4:34 下午     liuzhaolu       firstVersion
 */
@RequestMapping(value = "/credit")
@RestController
public class CreditController {

    @RequestMapping(value = "/addCredit", method = RequestMethod.GET)
    public String addCredit() {
        CreditInfo creditInfo = CreditInfo.builder()
                .score(99)
                .build();
        return JSONObject.toJSONString(creditInfo);
    }
}
