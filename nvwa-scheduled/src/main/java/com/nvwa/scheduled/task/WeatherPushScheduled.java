package com.nvwa.scheduled.task;


import com.alibaba.fastjson.JSONObject;
import com.nvwa.remote.response.WeatherData;
import com.nvwa.remote.service.CreditService;
import com.nvwa.remote.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/21 3:39 PM
 * @Version: 1.initial version; 2022/10/21 3:39 PM
 */
@Component
@Slf4j
public class WeatherPushScheduled {

//    @DubboReference(version = "1.0.0")
    @Resource(name = "weatherService")
    public WeatherService weatherService;

//    @DubboReference
//    public CreditService creditService;

    /**
     * 每日8点推送天气信息
     */
//    @Scheduled(cron = "0 0 2 * * ?")
    @Scheduled(fixedDelay = 1000, initialDelay = 3 * 1000)
    public void weatherPush() {
        log.info("开始推送天气....");
        WeatherData todayWeather = weatherService.getTodayWeather("");
        System.out.println(JSONObject.toJSONString(todayWeather));
//        creditService.getCreditInfo("ssss");
    }

}
