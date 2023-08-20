package com.zhang.learn.chapter2023.chapter08.chapter0819;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 有效括号
 */
public class ValidChar {
    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
        System.out.println(isValid("(((}}"));
    }
    private static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        char ch;
        for(int i=0;i<str.length();i++){
            ch = str.charAt(i);
            if(ch == '('){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if(ch == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.peek() != ch){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
