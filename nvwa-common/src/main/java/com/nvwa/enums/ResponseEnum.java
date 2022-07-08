package com.nvwa.enums;

/**
 * @author ：liuzhaolu
 * @description：返回枚举
 * @prd :
 * @date ：2022/1/19 3:40 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/19 3:40 下午     liuzhaolu       firstVersion
 */
public enum ResponseEnum {
    SUCCESS(0,"SUCCESS"),
    FAIL(500,"FAIL");
    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
