package com.nvwa.remote.remote;

import com.nvwa.remote.response.WeatherData;
import com.nvwa.remote.service.WeatherService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

//@DubboService(version = "1.0.0")
@Component(value = "weatherService")
public class WeatherServiceImpl implements WeatherService {

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
