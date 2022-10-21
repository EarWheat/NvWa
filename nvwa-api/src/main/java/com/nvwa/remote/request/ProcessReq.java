package com.nvwa.remote.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：liuzhaolu
 * @description：流程请求参数
 * @prd :
 * @date ：2022/3/30 6:42 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/30 6:42 下午     liuzhaolu       firstVersion
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessReq implements Serializable {

    /**
     * 流程id
     */
    @JSONField(name = "process_id")
    private String processId;
}
