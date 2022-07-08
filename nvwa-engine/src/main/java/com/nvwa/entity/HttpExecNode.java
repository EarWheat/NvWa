package com.nvwa.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

/**
 * @author ：liuzhaolu
 * @description：Http执行节点
 * @prd :
 * @date ：2022/3/24 2:56 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/24 2:56 下午     liuzhaolu       firstVersion
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpExecNode extends BaseExecNode {

    @JSONField(name = "ip")
    private String ip;

    @JSONField(name = "port")
    private Integer port;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "connectTimeOut")
    private Long connectTimeOut;

    @JSONField(name = "redTimeOut")
    private Long readTimeout;

    @JSONField(name = "request")
    private JSONObject request;

    @JSONField(name = "response")
    private JSONObject response;
}
