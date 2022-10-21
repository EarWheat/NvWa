package com.nvwa.remote.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Desc: 天气类
 * @Author: 泽露
 * @Date: 2022/10/21 3:56 PM
 * @Version: 1.initial version; 2022/10/21 3:56 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherData implements Serializable {

    private static final long serialVersionUID = 1047012784537358180L;

    /**
     * 天气
     */
    private String weather;
    /**
     * 温度
     */
    private String temperature;
    /**
     * 湿度
     */
    private String humidity;
}
