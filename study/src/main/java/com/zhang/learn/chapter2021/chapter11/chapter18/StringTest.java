package com.zhang.learn.chapter2021.chapter11.chapter18;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/11/18 17:07
 */
public class StringTest {
    public static void main(String[] args) {
        String url = "http://www.baidu.com?name={name}&age={age}";
        Map<String, String> param = new HashMap<>();
        param.put("name", "zhangsan");
        param.put("age", "18");
        for (Map.Entry<String, String> entry : param.entrySet()) {
            url = url.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        System.out.println(url);
        String a = "abc";
        System.out.println(a.replace("a", "d"));
    }

}
