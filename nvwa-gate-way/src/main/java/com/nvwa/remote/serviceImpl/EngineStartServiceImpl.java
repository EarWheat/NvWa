package com.nvwa.remote.serviceImpl;

import com.nvwa.remote.request.EngineRequest;
import com.nvwa.remote.response.ProcessResult;
import com.nvwa.remote.service.EngineService;
import com.nvwa.remote.service.EngineStartService;
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
