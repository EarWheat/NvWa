package com.nvwa.remote.wxOfficial;

import com.nvwa.remote.response.RestResult;
import com.nvwa.remote.service.wxOfficial.SubscribeService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Map;

/**
 * @Desc: 微信公众号发送订阅消息
 * @Author: 泽露
 * @Date: 2022/11/1 8:30 PM
 * @Version: 1.initial version; 2022/11/1 8:30 PM
 */
@DubboService(version = "1.0.0")
public class SubscribeServiceImpl implements SubscribeService {

    public static final String SUBSCRIBE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/subscribe/bizsend?access_token=%s";

    @Override
    public RestResult<Object> sendSubscribeMessage(String toUser, String templateId, String page, String miniProgram, Map<String, String> data) {
        return null;
    }
}
