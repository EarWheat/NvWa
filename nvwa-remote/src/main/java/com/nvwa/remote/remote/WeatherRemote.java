package com.nvwa.remote.remote;

import com.nvwa.remote.response.WeatherData;
import com.nvwa.remote.service.WeatherService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @Desc: 天气实现类
 * @Author: 泽露
 * @Date: 2022/10/21 5:09 PM
 * @Version: 1.initial version; 2022/10/21 5:09 PM
 */
@DubboService
public class WeatherRemote implements WeatherService {

    @Override
    public WeatherData getTodayWeather(String city) {
        WeatherData weatherData = WeatherData.builder()
                .weather("天气晴")
                .temperature("38")
                .humidity("80")
                .build();
        return weatherData;
    }
}
