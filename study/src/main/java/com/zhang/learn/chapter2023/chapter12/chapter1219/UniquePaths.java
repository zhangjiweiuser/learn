package com.zhang.learn.chapter2023.chapter12.chapter1219;

/**
 * ⼀一个机器器⼈人位于⼀一个 m x n ⽹网格的左上⻆角 （起始点在下图中标记为“Start” ）。
 * 机器器⼈人每次只能向下或者向右移动⼀一步。机器器⼈人试图达到⽹网格的右下⻆角（在下图中标记为“Finish”）。
 * 问总共有多少条不不同的路路径？
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePath(2,2));
        System.out.println(uniquePath(7,3));
    }
    public static int uniquePath(int m,int n){
        if(m<=0 || n <=0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
