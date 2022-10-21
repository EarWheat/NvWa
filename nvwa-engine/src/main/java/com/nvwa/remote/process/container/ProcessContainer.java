package com.nvwa.remote.process.container;

import com.nvwa.remote.entity.ProcessConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：liuzhaolu
 * @description：流程容器
 * @prd :
 * @date ：2022/3/30 6:46 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/30 6:46 下午     liuzhaolu       firstVersion
 */
@Component
public class ProcessContainer implements InitializingBean {

    private static ConcurrentHashMap<String, ProcessConfig> container = new ConcurrentHashMap<>(128);

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO:从数据库读取流程配置
        ProcessConfig processConfig = ProcessConfig.builder()
                .processId("liuzhaolu")
                .build();
        container.put(processConfig.getProcessId(), processConfig);
    }
}
