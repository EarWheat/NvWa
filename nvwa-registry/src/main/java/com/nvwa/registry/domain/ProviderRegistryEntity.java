package com.nvwa.registry.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @Desc: 服务提供者
 * @Author: 泽露
 * @Date: 2022/7/7 5:49 PM
 * @Version: 1.initial version; 2022/7/7 5:49 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProviderRegistryEntity implements Serializable {

    private static final long serialVersionUID = 3509309231812560498L;

    /**
     * 服务名
     */
    @JSONField(name = "name")
    public String name;

    /**
     * 方法
     */
    @JSONField(name = "method")
    public Method method;

    /**
     * 网络地址
     */
    @JSONField(name = "net_url")
    public NetUrl netUrl;
}
