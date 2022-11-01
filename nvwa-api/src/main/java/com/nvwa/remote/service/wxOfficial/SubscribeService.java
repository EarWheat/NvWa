package com.nvwa.remote.service.wxOfficial;

import com.nvwa.remote.response.RestResult;

import java.util.Map;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/1 6:30 PM
 * @Version: 1.initial version; 2022/11/1 6:30 PM
 */
public interface SubscribeService {

    /**
     * 发送微信公众号订阅消息
     * @param toUser 发送的用户
     * @param templateId 模版id
     * @param page 跳转的页面
     * @param miniProgram 跳转的小程序
     * @param data 数据data
     * @return
     */
    public RestResult<Object> sendSubscribeMessage(String toUser, String templateId, String page, String miniProgram, Map<String, String> data);
}
