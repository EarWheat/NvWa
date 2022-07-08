package com.nvwa.service;

import com.nvwa.response.OrderInfo;

/**
 * @author ：liuzhaolu
 * @description：订单系统
 * @prd :
 * @date ：2022/1/17 7:50 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 7:50 下午     liuzhaolu       firstVersion
 */
public interface OrderService {

    /**
     * 更新订单信息
     * @param orderInfo
     * @return
     */
    public OrderInfo updateOrderInfo(OrderInfo orderInfo);

    /**
     * 获取订单信息
     * @param orderId
     * @return
     */
    public OrderInfo getOrderInfo(String orderId);
}
