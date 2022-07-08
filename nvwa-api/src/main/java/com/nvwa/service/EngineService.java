package com.nvwa.service;

import com.alibaba.fastjson.JSONObject;
import com.nvwa.request.ProcessReq;
import com.nvwa.response.ProcessResult;

/**
 * @author ：liuzhaolu
 * @description：引擎接口
 * @prd :
 * @date ：2022/1/18 3:27 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/18 3:27 下午     liuzhaolu       firstVersion
 */
public interface EngineService {
    /**
     * 流程执行
     * @param req
     * @return
     * @throws Exception
     */
    public ProcessResult start(ProcessReq req) throws Exception;
}
