package com.nvwa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：liuzhaolu
 * @description：信用信息
 * @prd :
 * @date ：2022/1/17 7:53 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/17 7:53 下午     liuzhaolu       firstVersion
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreditInfo implements Serializable {

    public Integer score;
}
