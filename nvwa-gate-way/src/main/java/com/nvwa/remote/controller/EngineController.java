package com.nvwa.remote.controller;

import com.nvwa.remote.request.EngineRequest;
import com.nvwa.remote.response.RestResult;
import com.nvwa.remote.response.ProcessResult;
import com.nvwa.remote.service.EngineStartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：liuzhaolu
 * @description：引擎预热，主要用来匹配要执行的流程，以及安全校验降级
 * @prd :
 * @date ：2022/1/11 4:29 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/11 4:29 下午     liuzhaolu       firstVersion
 */
@RestController
@RequestMapping("/engine")
@Slf4j
public class EngineController {

    @Resource
    public EngineStartService engineStartService;


    /**
     * TODO：
     * 1.降级/限流
     * 2.幂等
     * @return
     */
    @RequestMapping("/start")
    public RestResult<ProcessResult> engineStart(EngineRequest engineRequest){
        long startTime = System.currentTimeMillis();
        ProcessResult result = null;
        try {
            result = engineStartService.exec(engineRequest);
        } catch (Exception e){
            RestResult.buildFail(result);
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("engine {} cost time:{}",engineRequest.getToken(), endTime - startTime);
        }
        return RestResult.buildSuccess(result);
    }
}
