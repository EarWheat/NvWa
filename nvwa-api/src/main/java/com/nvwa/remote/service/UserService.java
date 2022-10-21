package com.nvwa.remote.service;

import com.nvwa.remote.response.UserInfo;

/**
 * @author ：liuzhaolu
 * @description：司机系统
 * @prd :
 * @date ：2022/1/17 7:50 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 7:50 下午     liuzhaolu       firstVersion
 */
public interface UserService {

    /**
     * 更新司机信息
     * @param driverInfo
     * @return
     */
    public UserInfo updateDriverInfo(UserInfo driverInfo);

    /**
     * 获取司机信息
     * @param driverId
     * @return
     */
    public UserInfo getDriverInfo(String driverId);
}
