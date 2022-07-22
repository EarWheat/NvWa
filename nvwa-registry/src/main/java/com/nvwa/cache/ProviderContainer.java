package com.nvwa.cache;

import com.nvwa.domain.NetUrl;
import com.nvwa.domain.ProviderRegistryEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc: 服务提供者容器
 * @Author: 泽露
 * @Date: 2022/7/6 8:14 PM
 * @Version: 1.initial version; 2022/7/6 8:14 PM
 */
@Component
public class ProviderContainer {

    public static final ConcurrentHashMap<String, List<NetUrl>> container = new ConcurrentHashMap<>();

    public static void registry(ProviderRegistryEntity provider) {
        if (container.containsKey(provider.getName())) {
            List<NetUrl> urls = container.get(provider.getName());
            urls.add(provider.getNetUrl());
        } else {
            List<NetUrl> urls = new ArrayList<>();
            urls.add(provider.getNetUrl());
            container.put(provider.getName(), urls);
        }
    }

    public static List<NetUrl> getProviderList(ProviderRegistryEntity provider) {
        return container.get(provider.getName());
    }
}
