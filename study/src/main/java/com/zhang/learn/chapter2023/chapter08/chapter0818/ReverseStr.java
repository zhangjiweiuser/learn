package com.zhang.learn.chapter2023.chapter08.chapter0818;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 15:31
 */
public class ReverseStr {
    public static void main(String[] args) {
//        char[] ch = {'a', 'b', 'c', 'd', 'e', 'f', 'g','h'};
//        reverse3(ch, 3);
//        for (int i = 0; i < ch.length; i++) {
//            System.out.printf(ch[i] + "\t");
//        }
        String str = "abcdefg";
        String result = reverse4(str,2);
        System.out.println(result);
    }

    private static void reverse(char[] ch) {
        if (ch == null || ch.length == 0) {
            return;
        }
        int left = 0, right = ch.length - 1;
        while (left < right) {
            char t = ch[left];
            ch[left] = ch[right];
            ch[right] = t;
            left++;
            right--;
        }
    }

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * 示例:
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     *
     * @param ch
     * @param k
     */
    private static void reverse2(char[] ch, int k) {
        int i = 1;
        while (i * k * 2 <= ch.length) {
            int left = (i - 1) * k, right = i * k - 1;
            while (left < right) {
                char t = ch[left];
                ch[left] = ch[right];
                ch[right] = t;
                left++;
                right--;
            }
            i++;
        }

        if ((i - 1) * k * 2 < ch.length && i * k * 2 > ch.length) {
            int t = 0;
            if (((i - 1) * k * 2 + k) > ch.length) {
                t = ch.length - (i - 1) * 2 * k;
            } else {
                t = k;
            }

            // 反转t个
            int left = (i - 1) * 2 * k, right = left + t - 1;
            while (left < right) {
                char tmp = ch[left];
                ch[left] = ch[right];
                ch[right] = tmp;
                left++;
                right--;
            }

        }
    }

    // 和reverse2一样，更好的写法
    private static void reverse3(char[] ch, int k) {
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            int end = Math.min(ch.length - 1, start + k - 1);
            while(start < end){
                char tmp = ch[start];
                ch[start] = ch[end];
                ch[end] = tmp;
                start++;
                end--;
            }
        }
    }

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * @param str
     * @return
     */
    private static String reverse4(String str,int k){
        char[] chars = str.toCharArray();
        int i = 0;
        int m = k;
        while(i < m){
            char t = chars[i];
            chars[i] = chars[m-1];
            chars[m-1] = t;
            i++;
            m--;
        }
        i = str.length() -1;
        m = k;
        while(m <= i){
            char t = chars[i];
            chars[i] = chars[m];
            chars[m] = t;
            m++;
            i--;
        }
        i = 0;
        m = str.length()-1;
        while(i <= m){
            char t = chars[i];
            chars[i] = chars[m];
            chars[m] = t;
            m--;
            i++;
        }
        return new String(chars);
    }
}
