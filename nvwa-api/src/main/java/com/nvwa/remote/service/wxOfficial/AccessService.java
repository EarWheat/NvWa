package com.nvwa.remote.service.wxOfficial;

/**
 * @Desc: 接入服务
 * @Author: 泽露
 * @Date: 2022/11/1 8:34 PM
 * @Version: 1.initial version; 2022/11/1 8:34 PM
 */
public interface AccessService {

    /**
     * 获取微信公众号token
     *
     * @return
     */
    public String getAccessToken();
}
