package com.nvwa.remote.remote;


import com.nvwa.remote.response.CreditInfo;
import com.nvwa.remote.service.CreditService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author ：liuzhaolu
 * @description：信用模块
 * @prd :
 * @date ：2022/1/17 8:02 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 8:02 下午     liuzhaolu       firstVersion
 */
//@Component
@DubboService
public class CreditRemote implements CreditService {

    @Override
    public CreditInfo updateCreditInfo(CreditInfo creditInfo) {
        creditInfo.setScore(90);
        return creditInfo;
    }

    @Override
    public CreditInfo getCreditInfo(String driverId) {
        return CreditInfo.builder()
                .score(100)
                .build();
    }
}
