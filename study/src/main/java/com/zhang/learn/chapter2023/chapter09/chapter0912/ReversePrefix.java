package com.zhang.learn.chapter2023.chapter09.chapter0912;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-12 16:16
 */
public class ReversePrefix {
    public static void main(String[] args) {
        ReversePrefix reverse = new ReversePrefix();
        String s = reverse.reversePrefix("xyxzxe", 'z');
        System.out.println(s);
    }

    public String reversePrefix(String word, char ch) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        int i = 0;
        char[] arr = word.toCharArray();
        while (i < index) {
            char t = arr[i];
            arr[i] = arr[index];
            arr[index] = t;
            i++;
            index--;
        }
        StringBuffer sb = new StringBuffer();
        for(char c : arr){
            sb.append(c);
        }
        return sb.toString();
    }
}
