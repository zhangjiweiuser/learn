package com.zhang.learn.chapter2023.chapter03.chapter0317;

public class Kmp {
    public static void main(String[] args) {
        String s1 = "abczabc";
        String s2 = "zabcz";
        System.out.println(getIndex(s1,s2));
    }
    private static int getIndex(String s,String m){
        if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int[] next = getNextArr(str2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length && i2 < m.length()){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            } else if (next[i2] == -1) { // 说明已经回退到0的位置了还没有比对成功，则i1右移
                i1++;
            }else{
                i2 = next[i2];
            }
        }
        return i2 == m.length() ? i1 - i2 : -1;
    }

    private static int[] getNextArr(char[] ms){
        if(ms.length < 1){
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2; // next数组的位置
        while(i< ms.length){
            if(ms[i-1] == ms[cn]){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            } else{
                next[i++] = 0;
            }
        }
        return next;
    }
}
