package com.zhang.learn.chapter2023.chapter08.chapter0819;

import java.util.Stack;

public class DeleteDuplicate {
    public static void main(String[] args) {
        System.out.println(delete("abbaca"));
        System.out.println(delete("a"));
        System.out.println(delete("abbc"));
    }
    private static String delete(String origin){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<origin.length();i++){
            if(stack.isEmpty() || origin.charAt(i) != stack.peek()){
                stack.push(origin.charAt(i));
            }else {
                stack.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
