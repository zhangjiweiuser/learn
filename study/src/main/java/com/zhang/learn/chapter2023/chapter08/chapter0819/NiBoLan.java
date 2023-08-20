package com.zhang.learn.chapter2023.chapter08.chapter0819;

import java.util.Stack;

public class NiBoLan {
    public static void main(String[] args) {
        String[] arr1 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(arr1));
        String[] arr2 = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(arr2));
    }
    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(isOperate(s)){
                stack.push(cal(stack.pop(),stack.pop(),s));
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    private static boolean isOperate(String oper){
        return "+".equals(oper) || "-".equals(oper) ||
                "*".equals(oper) || "/".equals(oper);
    }
    private static int cal(int num1,int num2,String oper){
        if("+".equals(oper)){
            return num1+num2;
        } else if ("-".equals(oper)) {
            return num2 - num1;
        }else if ("*".equals(oper)) {
            return num2 * num1;
        }else{
            return num2 / num1;
        }
    }
}
