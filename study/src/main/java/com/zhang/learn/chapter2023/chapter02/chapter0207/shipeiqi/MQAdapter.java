package com.zhang.learn.chapter2023.chapter02.chapter0207.shipeiqi;

import com.alibaba.fastjson2.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 17:06
 */
public class MQAdapter {

    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0, 1) + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }
}
