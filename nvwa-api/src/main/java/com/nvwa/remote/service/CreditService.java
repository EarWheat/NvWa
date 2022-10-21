package com.nvwa.remote.service;

import com.nvwa.remote.response.CreditInfo;

/**
 * @author ：liuzhaolu
 * @description：信用系统
 * @prd :
 * @date ：2022/1/17 7:50 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 7:50 下午     liuzhaolu       firstVersion
 */
public interface CreditService {

    /**
     * 更新信用信息
     * @param creditInfo
     * @return
     */
    public CreditInfo updateCreditInfo(CreditInfo creditInfo);

    /**
     * 获取信用信息
     * @param driverId
     * @return
     */
    public CreditInfo getCreditInfo(String driverId);
}
