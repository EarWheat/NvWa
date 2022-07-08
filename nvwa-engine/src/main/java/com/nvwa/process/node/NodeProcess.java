package com.nvwa.process.node;

import com.nvwa.entity.BaseExecNode;
import com.nvwa.response.NodeResult;
import com.nvwa.exception.NodeProcessException;

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
