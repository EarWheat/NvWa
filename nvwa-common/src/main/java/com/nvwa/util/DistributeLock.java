package com.nvwa.util;

import org.redisson.Redisson;

/**
 * @author ：liuzhaolu
 * @description：分布式锁
 * @prd :
 * @date ：2022/1/24 2:04 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/24 2:04 下午     liuzhaolu       firstVersion
 */
public class DistributeLock {

    private Redisson redisson;

    public DistributeLock() {

    }

    public boolean lock(String key, Long expire){
        return false;
    }
}
