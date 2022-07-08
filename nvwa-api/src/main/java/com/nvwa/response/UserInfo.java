package com.nvwa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：liuzhaolu
 * @description：用户信息
 * @prd :
 * @date ：2022/1/17 7:53 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 7:53 下午     liuzhaolu       firstVersion
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo implements Serializable {

    public Long userId;

    public String userName;

    public CreditInfo creditInfo;
}
