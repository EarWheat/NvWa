package com.nvwa.service;

import com.alibaba.fastjson.JSONObject;
import com.nvwa.entity.EngineRequest;
import com.nvwa.response.ProcessResult;

/**
 * @author ：liuzhaolu
 * @description：启动引擎流程
 * @prd :
 * @date ：2022/1/11 5:35 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/11 5:35 下午     liuzhaolu       firstVersion
 */
public interface EngineStartService {

    public ProcessResult exec(EngineRequest params);
}
