package com.zhang.learn.chapter2024.chapter08.chapter0805;


import com.google.common.collect.Lists;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class XiaoMi {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
//        List<String> strings = FileUtils.readLines(new File("C:\\Users\\Administrator\\Downloads\\term_status-311-2024-06-28"));
//        for(String s : strings){
//            String[] split = s.split(",");
//            if("20240627".equals(split[3]) && "20240628".equals(split[5])){
//                System.out.println(s);
//            }
//        }
//        Map<Integer,Map<String, BigDecimal>> map1 = new HashMap<>();
//        Map<String,BigDecimal> map11 = new HashMap<>();
//        map11.put("a",BigDecimal.TEN);
//        map1.put(1,map11);
//        Map<Integer,Map<String,BigDecimal>> map2 =JSON.parseObject(JSON.toJSONString(map1),new TypeReference<Map<Integer,Map<String,BigDecimal>>>(){});
//        BigDecimal bigDecimal = map2.get(1).get("a");
//        System.out.println(bigDecimal);
//        map1.get(1).put("a",BigDecimal.ONE);
//        System.out.println(map2.get(1).get("a"));
        List<Integer> list = Lists.newArrayList(1,2,3,4,5);
        List<Integer> result = list.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList());
        System.out.println(result);
    }
}
