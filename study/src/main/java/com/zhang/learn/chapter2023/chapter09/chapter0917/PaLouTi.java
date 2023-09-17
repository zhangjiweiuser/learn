package com.zhang.learn.chapter2023.chapter09.chapter0917;

public class PaLouTi {
    public static void main(String[] args) {
        System.out.println(palouti(5));
    }
    private static int palouti(int n){
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        int sum = 0;
        for(int i=3;i<=n;i++){
            sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
