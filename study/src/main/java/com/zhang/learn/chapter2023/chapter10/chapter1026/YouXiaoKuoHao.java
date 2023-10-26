package com.zhang.learn.chapter2023.chapter10.chapter1026;

import java.util.Deque;
import java.util.LinkedList;

public class YouXiaoKuoHao {
    public static void main(String[] args) {
        System.out.println(isValid("(())"));
        System.out.println(isValid("(([))"));
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(ch == '('){
                deque.add(')');
            } else if (ch == '{') {
               deque.add('}');
            } else if (ch == '[') {
                deque.add(']');
            }else if(deque.isEmpty() || deque.peek() != ch){
                return false;
            }else{
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
