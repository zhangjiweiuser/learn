package com.zhang.learn.chapter2022.chapter01.chapter0130;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonFromSentences {
    public static void main(String[] args) {
        UncommonFromSentences diff = new UncommonFromSentences();
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        System.out.println(diff.uncommonFromSentences(s1, s2));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>();
        String[] arr1 = s1.split(" ");
        for (String s : arr1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> map2 = new HashMap<>();
        String[] arr2 = s2.split(" ");
        for (String s : arr2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && map2.get(entry.getKey()) == null) {
                result.add(entry.getKey());
            }
        }
        for (Map.Entry<String,Integer> entry : map2.entrySet()) {
            if (entry.getValue() == 1 && map1.get(entry.getKey()) == null) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }
}
