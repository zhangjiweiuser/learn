package com.zhang.learn.chapter2023.chapter08.chapter0816;

public class FeiBoNaQie {
    public static void main(String[] args) {
        System.out.println(add1(7));
        System.out.println(add2(7));
    }
    private static int add1(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return add1(n-1) + add1(n-2);
    }
    private static int add2(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int ans = 0,f0=1,f1=1;
        int t=2;
        while(t++ <= n){
            ans = f0+f1;
            f0=f1;
            f1=ans;
        }
        return ans;
    }
}
