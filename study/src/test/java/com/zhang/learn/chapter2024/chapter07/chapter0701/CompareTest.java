package com.zhang.learn.chapter2024.chapter07.chapter0701;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareTest {
    @Test
    public void test1(){
        List<String> periods = new ArrayList<>();
//        periods.add("1");
//        periods.add("2");
//        periods.add("3");
//        periods.add("4");
//        periods.add("8");
//        periods.add("9");
//        periods.add("10");
//        periods.add("11");
//        periods.add("12");
//        periods.sort(Comparator.comparing(Integer::valueOf));
//        System.out.println(periods);
        Map<String,String> map = new HashMap<>();
        map.put("a","a");
        Map<String, String> map2 = new HashMap<>(map);
        map2.put("b","b");
        map.put("c","c");
        System.out.println(map);
        System.out.println(map2);
    }
}
