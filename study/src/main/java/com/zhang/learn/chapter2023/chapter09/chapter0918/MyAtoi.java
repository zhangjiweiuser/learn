package com.zhang.learn.chapter2023.chapter09.chapter0918;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-18 15:37
 */
public class MyAtoi {
    public static void main(String[] args) {
//        System.out.println(myAtoi("    0042"));
        System.out.println(myAtoi("+2"));
    }

    public static int myAtoi(String s) {
        int sum = 0;
        boolean flag = false;
        boolean yuejie = false;
        boolean youfuhao = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ' && c != '-' && c != '+'&& (c < '0' || c > '9')) {
                break;
            }
            if(c == '+' || c == '-'){
                if(youfuhao){
                    return 0;
                }else{
                    youfuhao = true;
                }
            }
            if (c == ' ' || c == '+'){
                continue;
            }

            if (c == '-') {
                flag = true;
            } else {
                int t = sum * 10 + (c - '0');
                if (t < sum) {
                    sum = Integer.MAX_VALUE;
                    yuejie = true;
                    break;
                } else {
                    sum = t;
                }
            }
        }
        return flag ? yuejie ?  -1 * sum -1 : -1 * sum : yuejie ? sum - 1 : sum;
    }
}
