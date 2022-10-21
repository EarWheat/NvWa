package com.nvwa.remote.service;

import com.nvwa.remote.response.WeatherData;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/10/21 3:55 PM
 * @Version: 1.initial version; 2022/10/21 3:55 PM
 */
public interface WeatherService {

    /**
     * 根据城市获取今日天气
     *
     * @param city
     * @return
     */
    public WeatherData getTodayWeather(String city);
}
