package com.nvwa.remote.response;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：liuzhaolu
 * @description：节点执行结果
 * @prd :
 * @date ：2022/3/25 2:54 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/25 2:54 下午     liuzhaolu       firstVersion
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeResult {

    @JSONField(name = "response")
    public JSONObject response;
}
