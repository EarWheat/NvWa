package com.nvwa.scheduled.task;


import com.alibaba.fastjson.JSONObject;
import com.nvwa.remote.response.RestResult;
import com.nvwa.remote.response.WeatherData;
import com.nvwa.remote.service.WeatherService;
import com.nvwa.util.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/21 3:39 PM
 * @Version: 1.initial version; 2022/10/21 3:39 PM
 */
@Component
@Slf4j
public class WeatherPushScheduled {

    @DubboReference(version = "1.0.0")
    public WeatherService weatherService;

    /**
     * 每日8点推送天气信息
     */
    @Scheduled(fixedDelay = 1000, initialDelay = 3 * 1000)
    public void weatherPush() {
        log.info("开始推送天气....");
        WeatherData todayWeather = weatherService.getTodayWeather("");
        System.out.println(JSONObject.toJSONString(todayWeather));
        try {
            RestResult<Object> objectRestResult = HttpClient.doPost(new HashMap<>(), "http://127.0.0.1:8092/order/getOrderInfo");
            System.out.println(objectRestResult.getData().toString());
        } catch (Exception e){
            e.printStackTrace();
        }
//        creditService.getCreditInfo("ssss");
    }

}
