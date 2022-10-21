package com.nvwa.remote.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：流程配置
 * @prd :
 * @date ：2022/3/30 6:50 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/30 6:50 下午     liuzhaolu       firstVersion
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessConfig implements Serializable {

    @JSONField(name = "process_id")
    private String processId;

    @JSONField(name = "node_list")
    private List<BaseExecNode> nodes;
}
