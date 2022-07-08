package com.nvwa.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.nvwa.entity.EngineRequest;
import com.nvwa.response.ProcessResult;
import com.nvwa.service.DubboDemoService;
import com.nvwa.service.EngineService;
import com.nvwa.service.EngineStartService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * @author ：liuzhaolu
 * @description：启动引擎流程实现类
 * @prd :
 * @date ：2022/1/11 5:36 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/11 5:36 下午     liuzhaolu       firstVersion
 */
@Component
public class EngineStartServiceImpl implements EngineStartService {

    @DubboReference
    private EngineService engineService;

    @Override
    public ProcessResult exec(EngineRequest params) {
        ProcessResult result = null;
        try {
            result = engineService.start(params.getParams());
        } catch (Exception e){

        }
        return result;
    }
}
