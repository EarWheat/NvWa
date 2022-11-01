package com.nvwa.remote.service;

import com.nvwa.remote.request.EngineRequest;
import com.nvwa.remote.response.ProcessResult;

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
