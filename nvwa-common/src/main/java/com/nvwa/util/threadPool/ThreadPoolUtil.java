package com.nvwa.util.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：liuzhaolu
 * @description：静态方法；单例获取
 * @prd :
 * @date ：2022/3/24 3:00 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/24 3:00 下午     liuzhaolu       firstVersion
 */
public class ThreadPoolUtil {

    private static ThreadPoolExecutor poolInstance = null;

    private ThreadPoolUtil(){};

    public static ThreadPoolExecutor getPool(){
        if(poolInstance == null){
            synchronized (ThreadPoolUtil.class){
                if(poolInstance == null){
                    poolInstance = new ThreadPoolExecutor(10,10,500, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());
                }
            }
        }
        return poolInstance;
    }

}
