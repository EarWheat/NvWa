package com.nvwa.remote;


import com.nvwa.response.CreditInfo;
import com.nvwa.service.CreditService;
import org.springframework.stereotype.Component;

/**
 * @author ：liuzhaolu
 * @description：信用模块
 * @prd :
 * @date ：2022/1/17 8:02 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 8:02 下午     liuzhaolu       firstVersion
 */
@Component
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
