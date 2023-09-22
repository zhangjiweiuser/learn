package com.zhang.learn.chapter2023.chapter09.chapter0921;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-21 17:19
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("abc"));
    }

    public static int lengthOfLastWord(String s) {
        int end = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && end != -1) {
                return end - i;
            } else {
                if (s.charAt(i) != ' ' && end == -1) {
                    end = i;
                }
            }
        }
        return end == -1 ? s.length() : end + 1;
    }
}
