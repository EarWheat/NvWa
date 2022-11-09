package com.nvwa.remote.remote;

import com.alibaba.fastjson.JSONObject;
import com.nvwa.remote.response.RestResult;
import com.nvwa.remote.response.WeatherData;
import com.nvwa.remote.service.WeatherService;
import com.nvwa.util.HttpClient;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
//@Component(value = "weatherService")
public class WeatherServiceImpl implements WeatherService {

    public static final String WEATHER_URL = "https://v0.yiketianqi.com/api?unescape=1&version=v91&appid=43656176&appsecret=I42og6Lm&cityid=%s";

    @Override
    public WeatherData getTodayWeather(String city) {
        WeatherData weatherData = new WeatherData();
        try {
            String url = String.format(WEATHER_URL, "101010100");
            RestResult<Object> result = HttpClient.doGet(url);
            String response = result.getData().toString();
            weatherData = JSONObject.parseObject(response, WeatherData.class);
        } catch (Exception e){

        }
        return weatherData;
    }
}
