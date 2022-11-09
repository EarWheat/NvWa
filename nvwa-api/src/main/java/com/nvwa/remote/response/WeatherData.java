package com.nvwa.remote.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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

    @JSONField(name = "cityid")
    private Long cityId;

    @JSONField(name = "city")
    private String cityName;

    @JSONField(name = "update_time")
    private String time;

    @JSONField(name = "data")
    private List<WeatherDetail> detail;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class WeatherDetail {

        @JSONField(name = "day")
        public String day;

        @JSONField(name = "date")
        public String date;

        @JSONField(name = "week")
        public String week;

        @JSONField(name = "tem")
        public Double tem;

        @JSONField(name = "tem1")
        public Double maxTem;

        @JSONField(name = "tem2")
        public Double minTem;
    }

}
