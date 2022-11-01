package com.nvwa.remote.wxOfficial;

import com.nvwa.remote.service.wxOfficial.AccessService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Desc: 获取微信公众号access
 * @Author: 泽露
 * @Date: 2022/11/1 8:35 PM
 * @Version: 1.initial version; 2022/11/1 8:35 PM
 */
public class AccessServiceImpl implements AccessService {

    @Value("${wx.official.appId}")
    private String appId;

    @Value("${wx.official.secret}")
    private String secret;

    public static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";


    @Override
    public String getAccessToken() {


        return null;
    }
}
