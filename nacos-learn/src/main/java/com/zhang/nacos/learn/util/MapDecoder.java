package com.zhang.nacos.learn.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

public class MapDecoder {
    public static Map<String, String> decodeMap(String value) {
        try {
            return JSONObject.parseObject(value, new TypeReference<Map<String, String>>(){});
        } catch (Exception e) {
            return null;
        }
    }

}
