package com.nvwa.remote.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：订单信息
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
public class OrderInfo implements Serializable {

    public Long userId;

    public Integer status;

    public String userName;

    public List<Item> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Item implements Serializable{
        public String name;
        public Double price;
    }

}
