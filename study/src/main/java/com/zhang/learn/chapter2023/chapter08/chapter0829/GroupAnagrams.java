package com.zhang.learn.chapter2023.chapter08.chapter0829;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-29 14:05
 */
public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String hash = getStrHash(str);
            if(!groups.containsKey(hash)){
                groups.put(hash,new ArrayList<>());
            }
            groups.get(hash).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : groups.keySet()){
            res.add(groups.get(key));
        }
        return res;
    }

    private static String getStrHash(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                sb.append((char) ('a' + i));
                sb.append(counts[i]);
            }
        }
        return sb.toString();
    }
}
