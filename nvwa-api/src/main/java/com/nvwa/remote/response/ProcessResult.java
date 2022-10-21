package com.nvwa.remote.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：流程结果
 * @prd :
 * @date ：2022/3/30 6:40 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/30 6:40 下午     liuzhaolu       firstVersion
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessResult implements Serializable {

    @JSONField(name = "node_result")
    List<NodeResult> nodeResults;
}
