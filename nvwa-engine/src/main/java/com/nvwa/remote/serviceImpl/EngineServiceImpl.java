package com.nvwa.remote.serviceImpl;

import com.nvwa.remote.entity.BaseExecNode;
import com.nvwa.remote.entity.HttpExecNode;
import com.nvwa.remote.response.NodeResult;
import com.nvwa.remote.process.node.HttpNodeProcess;
import com.nvwa.remote.request.ProcessReq;
import com.nvwa.remote.response.ProcessResult;
import com.nvwa.remote.service.CreditService;
import com.nvwa.remote.service.EngineService;
import com.nvwa.remote.service.OrderService;
import com.nvwa.remote.service.UserService;
import com.nvwa.util.threadPool.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ：liuzhaolu
 * @description：引擎执行
 * @prd :
 * @date ：2022/1/18 3:28 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/18 3:28 下午     liuzhaolu       firstVersion
 */
@Component
@Slf4j
public class EngineServiceImpl implements EngineService {

    @DubboReference
    public OrderService orderService;

    @DubboReference
    public CreditService creditService;

    @DubboReference
    public UserService userService;

    @Resource
    public HttpNodeProcess httpNodeProcess;

    @Override
    public ProcessResult start(ProcessReq start) throws Exception {
        Map<String, Object> context = new HashMap<>();
        HttpExecNode orderNode = HttpExecNode.builder()
                .ip("127.0.0.1")
                .port(8092)
                .url("/order/getOrderInfo")
                .build();
        HttpExecNode creditNode = HttpExecNode.builder()
                .ip("127.0.0.1")
                .port(8092)
                .url("/credit/addCredit")
                .build();
        List<BaseExecNode> execNodes = new ArrayList<>();
        execNodes.add(orderNode);
        execNodes.add(creditNode);
        AtomicReference<CompletableFuture<NodeResult>> nodeFeature = new AtomicReference<>();
        execNodes.forEach(node -> {
            nodeFeature.set(CompletableFuture.supplyAsync(() -> {
                NodeResult nodeResult = null;
                try {
                    nodeResult = httpNodeProcess.execNode(node);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return nodeResult;
            }, ThreadPoolUtil.getPool()));
        });
        CompletableFuture<NodeResult> future = nodeFeature.get();
        try {
            NodeResult nodeResult = future.get();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
