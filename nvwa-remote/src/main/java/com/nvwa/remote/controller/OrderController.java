package com.nvwa.remote.controller;

import com.alibaba.fastjson.JSONObject;
import com.nvwa.remote.response.OrderInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liuzhaolu
 * @description：订单controller
 * @prd :
 * @date ：2022/3/25 4:28 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/25 4:28 下午     liuzhaolu       firstVersion
 */
@RequestMapping(value = "/order")
@RestController
public class OrderController {

    @RequestMapping(value = "/getOrderInfo", method = RequestMethod.POST)
    public String getOrderInfo() {
        OrderInfo orderInfo = OrderInfo.builder()
                .userId(123456L)
                .userName("zero")
                .status(0)
                .build();
        return JSONObject.toJSONString(orderInfo);
    }
}
