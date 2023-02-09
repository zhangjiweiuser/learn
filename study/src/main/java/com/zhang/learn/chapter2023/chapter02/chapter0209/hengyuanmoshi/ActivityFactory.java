package com.zhang.learn.chapter2023.chapter02.chapter0209.hengyuanmoshi;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:25
 */
public class ActivityFactory {

    static Map<Long,Activity> activityMap = new HashMap<>();

    public static Activity getActivity(Long id){
        Activity activity = activityMap.get(id);
        if(null == activity){
            activity = new Activity();
            activity.setId(100L);
            activity.setName("设计模式");
            activity.setDesc("让你的技术更上一层楼");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id,activity);
        }
        return activity;
    }
}
