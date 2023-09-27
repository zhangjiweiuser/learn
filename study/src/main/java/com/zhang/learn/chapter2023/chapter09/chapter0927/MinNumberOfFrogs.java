package com.zhang.learn.chapter2023.chapter09.chapter0927;

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。
 * 由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 * <p>
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。
 * 如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs
 * 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 */
public class MinNumberOfFrogs {
    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcroak"));
        System.out.println(minNumberOfFrogs("crcoakroak"));
        System.out.println(minNumberOfFrogs("croakcrook"));
    }

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0, res = 0;
        char[] charArray = croakOfFrogs.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'c') {
                if (k > 0) {
                    k--;
                } else {
                    res++;
                }
                c++;
            } else if (charArray[i] == 'r') {
                c--;
                r++;
            } else if (charArray[i] == 'o') {
                r--;
                o++;
            } else if (charArray[i] == 'a') {
                o--;
                a++;
            } else if (charArray[i] == 'k') {
                a--;
                k++;
            }
            if (c < 0 || r < 0 || o < 0 || a < 0) {
                break;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) {
            return -1;
        }
        return res;
    }
}
