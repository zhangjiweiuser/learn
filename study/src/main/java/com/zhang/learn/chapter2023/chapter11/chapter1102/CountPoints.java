package com.zhang.learn.chapter2023.chapter11.chapter1102;

import java.util.*;

public class CountPoints {
    public static void main(String[] args) {
        int t = 0;
        int a = t |= 1;

        System.out.println(a);
//        String rings = "B0R0G0R9R0B0G0";

    }

    public static int countPoints2(String rings) {
        int ans = 0;
        char[] charArray = rings.toCharArray();
        int[] num = new int[10];
        for (int i = 1; i < rings.length(); i += 2) {
            num[charArray[i] - '0'] |= charArray[i-1] == 'R' ? 1 :charArray[i-1] == 'G' ? 2 :4;
        }
        for(int i : num){
            if(i == 7){
                ans += 1;
            }
        }
        return ans;
    }
    public static int countPoints(String rings) {
        int ans = 0;
        Map<Integer,Set<Character>> list = new HashMap<>();
        for (int i = 1; i < rings.length(); i += 2) {
            Set<Character> characters = list.get(rings.charAt(i) - '0');
            if(characters == null){
                characters = new HashSet<>();
            }
            characters.add(rings.charAt(i-1));
            list.put(rings.charAt(i) - '0',characters);
        }
        for(Map.Entry<Integer,Set<Character>> set : list.entrySet()){
            if(set.getValue().size() == 3){
                ans+=1;
            }
        }
        return ans;
    }
}
