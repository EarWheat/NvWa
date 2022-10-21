package com.nvwa.remote.process.node;

import com.alibaba.fastjson.JSONObject;
import com.nvwa.remote.entity.BaseExecNode;
import com.nvwa.remote.entity.HttpExecNode;
import com.nvwa.remote.exception.NodeProcessException;
import com.nvwa.remote.response.NodeResult;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author ：liuzhaolu
 * @description：Http节点处理器
 * @prd :
 * @date ：2022/3/25 2:55 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/25 2:55 下午     liuzhaolu       firstVersion
 */
@Component
@Slf4j
public class HttpNodeProcess implements NodeProcess {

    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";

    /**
     * 执行Http组件
     * @param node
     * @return
     * @throws NodeProcessException
     */
    @Override
    public NodeResult execNode(BaseExecNode node) throws NodeProcessException {
        if (!(node instanceof HttpExecNode)) {
            throw new NodeProcessException();
        }
        NodeResult nodeResult = null;
        try {
            HttpExecNode httpExecNode = (HttpExecNode) node;
            if(!checkParam(httpExecNode)){
                throw new NodeProcessException();
            }
            OkHttpClient httpClient = new OkHttpClient()
                    .newBuilder()
                    .connectTimeout(Optional.ofNullable(httpExecNode.getConnectTimeOut()).orElse(500L), TimeUnit.MILLISECONDS)
                    .readTimeout(Optional.ofNullable(httpExecNode.getConnectTimeOut()).orElse(500L), TimeUnit.MILLISECONDS)
                    .build();
            String requestAddress = HTTP + httpExecNode.getIp() + ":" + httpExecNode.getPort();
            String url = requestAddress + httpExecNode.getUrl();
            Request request = new Request
                    .Builder()
                    .url(url)
                    .build();
            try (Response response = httpClient.newCall(request).execute()){
                if (response.isSuccessful()) {
                    String str = response.body().string();
                    // 得到响应体中的身体,将其转成  string
                    JSONObject resp = JSONObject.parseObject(str);
                    nodeResult = new NodeResult(resp);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nodeResult;
    }

    public boolean checkParam(HttpExecNode execNode) {
        if (Objects.isNull(execNode.getIp())
                || Objects.isNull(execNode.getPort())
                || Objects.isNull(execNode.getUrl())) {
            return false;
        }
        return true;
    }
}
