package com.zhang.learn.chapter2023.chapter02.chapter0207.yuanxingmoshi;

import java.util.*;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 10:05
 */
public class TopicRandomUtil {
    public static Topic random(Map<String,String> option, String key){
        Set<String> keySet = option.keySet();
        ArrayList<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        System.out.println(keyList);
        Map<String,String> optionNew = new HashMap<>();
        int idx = 0;
        String keyNew = "";
        for(String next : keySet){
            String randomKey = keyList.get(idx++);
            if(key.equals(next)){
                keyNew = randomKey;
            }
            optionNew.put(randomKey,option.get(next));
        }
        return new Topic(optionNew,keyNew);
    }

    public static void main(String[] args) {
        Map<String, String> map01 = new HashMap<String, String>();
        map01.put("A", "JAVA2 EE");
        map01.put("B", "JAVA2 Card");
        map01.put("C", "JAVA2 ME");
        map01.put("D", "JAVA2 HE");
        map01.put("E", "JAVA2 SE");
        System.out.println(map01);
        Topic topic = random(map01, "D");
        System.out.println(topic);
    }
}
