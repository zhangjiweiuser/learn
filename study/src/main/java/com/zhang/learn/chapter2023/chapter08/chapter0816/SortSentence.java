package com.zhang.learn.chapter2023.chapter08.chapter0816;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-16 11:13
 */
public class SortSentence {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
    public static String sortSentence(String s) {
        String[] split = s.split("\\s");
        String[] ans = new String[split.length];
        for(int i=0;i<split.length;i++){
            int n = Integer.parseInt(String.valueOf(split[i].charAt(split[i].length()-1)));
            ans[n-1] = split[i].substring(0,split[i].length()-1);
        }

        StringBuffer sb = new StringBuffer();
        for(String a : ans){
            sb.append(a).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
