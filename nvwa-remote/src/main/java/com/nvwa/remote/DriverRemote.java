package com.nvwa.remote;

import com.nvwa.response.UserInfo;
import com.nvwa.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author ：liuzhaolu
 * @description：司机模块
 * @prd :
 * @date ：2022/1/17 8:01 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 8:01 下午     liuzhaolu       firstVersion
 */
@Component
public class DriverRemote implements UserService {

    @Override
    public UserInfo updateDriverInfo(UserInfo userInfo) {
        System.out.println("update user info");
        return null;
    }

    @Override
    public UserInfo getDriverInfo(String userId) {
        return null;
    }
}
