package com.zhang.learn.chapter2023.chapter02.chapter0209.hengyuanmoshi;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:20
 */
public class ActivityController {
    private RedisUtil redisUtil = new RedisUtil();
    public Activity queryActivityInfo(){
        Activity activity = new Activity();
        activity.setId(100L);
        activity.setName("设计模式");
        activity.setDesc("让你的技术更上一层楼");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(100,1));
        return activity;
    }

    public Activity queryActivityInfo2(Long id){
        Activity activity = ActivityFactory.getActivity(id);
        Stock stock = new Stock(100, redisUtil.getStockUsed());
        activity.setStock(stock);
        return activity;
    }
}
