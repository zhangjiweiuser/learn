package com.zhang.learn.chapter2023.chapter08.chapter0809.recursion;

import java.util.Stack;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-09 16:16
 */
public class JiSuanQi {
    public static void main(String[] args) {
        // 无法处理负数，因为负数在下面解法中会被认为是符号，导致无法解析
//        String s = "(2*(3-4))*5";
        String s = "(2*(6-4))*5";
        System.out.println(solve(s));

    }

    public static int solve(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        char ch = ' ';
        int res = 0;
        String keepNum = "";
        while (true) {
            ch = s.charAt(index);
            System.out.println(String.valueOf(ch));
            // 如果是一个符号
            if (isOper(ch)) {
                if (operStack.isEmpty() || '(' == ch) {
                    operStack.push(ch);
                } else {
                    if (')' != ch) {
                        if(operStack.peek() == '('){
                            operStack.push(ch);
                        }else{
                            if (priority(ch) <= priority(operStack.peek())) {
                                num1 = numStack.pop();
                                num2 = numStack.pop();
                                res = cal(num1, num2, operStack.pop());
                                numStack.push(res);
                                operStack.push(ch);
                            } else {
                                operStack.push(ch);
                            }
                        }

                    }else{
                        String newS = "";
                        while(operStack.peek() != '('){
                            newS = numStack.pop() + newS;
                            newS = operStack.pop() + newS;
                        }
                        System.out.println("------   "+newS);
                        operStack.pop();
                        newS = numStack.pop() + newS;
                        numStack.push(solve(newS));

                    }
                }
            } else {
                // 说明是一个数
                keepNum += ch;
                if (index == s.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (isOper(s.charAt(index + 1))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index == s.length()) {
                break;
            }
        }
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            res = cal(num1, num2, operStack.pop());
            numStack.push(res);
        }
        return numStack.pop();
    }

    public static boolean isOper(char a) {
        return !(String.valueOf(a)).matches("\\d+");
    }

    public static int priority(char a) {
        if (a == '*' || a == '/') {
            return 1;
        } else {
            return 0;
        }
    }

    public static int cal(int num1, int num2, char ch) {
        if (ch == '*') {
            return num1 * num2;
        } else if (ch == '/') {
            return num2 / num1;
        } else if (ch == '+') {
            return num1 + num2;
        } else {
            return num2 - num1;
        }
    }
}
