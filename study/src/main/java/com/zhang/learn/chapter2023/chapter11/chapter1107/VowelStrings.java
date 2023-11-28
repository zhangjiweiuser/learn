package com.zhang.learn.chapter2023.chapter11.chapter1107;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个下标从 0 开始的字符串数组 words 和两个整数：left 和 right 。
 * 如果字符串以元音字母开头并以元音字母结尾，那么该字符串就是一个 元音字符串 ，其中元音字母是 'a'、'e'、'i'、'o'、'u' 。
 * 返回 words[i] 是元音字符串的数目，其中 i 在闭区间 [left, right] 内。
 * 示例 1：
 * 输入：words = ["are","amy","u"], left = 0, right = 2
 * 输出：2
 * 解释：
 * - "are" 是一个元音字符串，因为它以 'a' 开头并以 'e' 结尾。
 * - "amy" 不是元音字符串，因为它没有以元音字母结尾。
 * - "u" 是一个元音字符串，因为它以 'u' 开头并以 'u' 结尾。
 * 在上述范围中的元音字符串数目为 2 。
 */
public class VowelStrings {
    public static void main(String[] args) {

    }

    public static int vowelStrings(String[] words, int left, int right) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        map.put('e'-'a',1);
        map.put('i'-'a',1);
        map.put('o'-'a',1);
        map.put('u'-'a',1);
        int ans = 0;
        for(int i=left;i<=right;i++){
            String word = words[i];
            if(map.get(word.charAt(0)-'a') != null && map.get(word.charAt(word.length()-1)-'a') != null){
                ans+=1;
            }
        }
        return ans;
    }
}
