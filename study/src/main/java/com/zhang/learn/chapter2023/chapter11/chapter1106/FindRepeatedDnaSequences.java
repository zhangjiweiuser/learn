package com.zhang.learn.chapter2023.chapter11.chapter1106;

import java.util.*;

/**
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 */
public class FindRepeatedDnaSequences {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length()<=10){
            return new ArrayList<>();
        }
        Map<String,Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i+10 <= s.length(); i++) {
            String newS = s.substring(i,i+10);
            map.put(newS,map.getOrDefault(newS,0)+1);
            if(map.getOrDefault(newS,0) == 2){
                ans.add(newS);
            }
        }
        return ans;
    }
}
