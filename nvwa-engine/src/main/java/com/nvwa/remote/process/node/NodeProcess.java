package com.nvwa.remote.process.node;

import com.nvwa.remote.entity.BaseExecNode;
import com.nvwa.remote.exception.NodeProcessException;
import com.nvwa.remote.response.NodeResult;

/**
 * @author ：liuzhaolu
 * @description：节点处理器
 * @prd :
 * @date ：2022/3/25 2:52 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/25 2:52 下午     liuzhaolu       firstVersion
 */
public interface NodeProcess {

    /**
     * 执行节点
     * @param node
     * @return
     */
    NodeResult execNode(BaseExecNode node) throws NodeProcessException;

}
