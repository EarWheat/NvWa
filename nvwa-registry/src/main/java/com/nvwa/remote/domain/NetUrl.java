package com.nvwa.remote.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Desc: 网络地址
 * @Author: 泽露
 * @Date: 2022/7/8 4:58 PM
 * @Version: 1.initial version; 2022/7/8 4:58 PM
 */
@Data
public class NetUrl {

    /**
     * host地址
     */
    @Value("${registry.host:127.0.0.1}")
    private String host;

    /**
     * 端口
     */
    @Value("${registry.port:8091}")
    private Integer port;

    public static NetUrl getRegistryUrl() {
        return new NetUrl();
    }

}
