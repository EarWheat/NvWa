package com.nvwa.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.nvwa.request.ProcessReq;
import jodd.util.ProcessRunner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：liuzhaolu
 * @description：引擎入参
 * @prd :
 * @date ：2022/1/19 3:46 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/19 3:46 下午     liuzhaolu       firstVersion
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EngineRequest implements Serializable {

    /**
     * 调用方
     */
    @JSONField(name = "caller")
    public String caller;

    /**
     * token，用来限流，验证，幂等，等等
     */
    @JSONField(name = "token")
    public String token;

    /**
     * 实际入参
     */
    @JSONField(name = "params")
    public ProcessReq params;
}
