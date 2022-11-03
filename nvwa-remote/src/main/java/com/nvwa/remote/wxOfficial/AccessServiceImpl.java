package com.nvwa.remote.wxOfficial;

import com.nvwa.remote.response.RestResult;
import com.nvwa.remote.service.wxOfficial.AccessService;
import com.nvwa.util.HttpClient;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

/**
 * @Desc: 获取微信公众号access
 * @Author: 泽露
 * @Date: 2022/11/1 8:35 PM
 * @Version: 1.initial version; 2022/11/1 8:35 PM
 */
@DubboService(version = "1.0.0")
public class AccessServiceImpl implements AccessService {

    @Value("${wx.official.appId}")
    private String appId;

    @Value("${wx.official.secret}")
    private String secret;

    public static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";


    @Override
    public String getAccessToken() {
        String url = String.format(TOKEN_URL, appId, secret);
        try {
            RestResult<Object> result = HttpClient.doGet(url);
            if (0 == Optional.ofNullable(result.getErrno()).orElse(-1)) {
                return String.valueOf(result.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Strings.EMPTY;
    }
}
