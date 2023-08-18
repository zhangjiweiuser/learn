package com.zhang.learn.chapter2023.chapter08.chapter0818;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1： 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 16:16
 */
public class ReplaceBlank {
    public static void main(String[] args) {

        System.out.println(replace("we are h"));
    }

    private static String replace(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        char[] ch = new char[str.length() + 2 * count];
        int j = ch.length-1;
        for(int i = str.length()-1;i>=0;i--){
            if(str.charAt(i) != ' '){
                ch[j--] = str.charAt(i);
            }else{
                ch[j--] = '0';
                ch[j--] = '2';
                ch[j--] = '%';
            }
        }

        return new String(ch);
    }
}
