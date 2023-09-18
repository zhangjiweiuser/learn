package com.zhang.learn.chapter2023.chapter09.chapter0918;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * 输入：m = 2, n = 3
 * 输出：3
 * <p>
 * 解释： 从左上角开始，总共有 3 条路径可以到达右下角。
 * 向右 -> 向右 -> 向下
 * 向右 -> 向下 -> 向右
 * 向下 -> 向右 -> 向右
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-09-18 11:23
 */
public class BuTongLuJing2 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0, 1,0}, {0,0, 0}};
        System.out.println(LuJing(grid));
    }

    private static int LuJing(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int k = n;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                k = i;
                break;
            }
        }
        for (int i = 0; i < k; i++) {
            dp[0][i] = 1;
        }
        int t = m;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                t = i;
                break;
            }
        }
        for (int i = 0; i < t; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        for (int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }
        return dp[m - 1][n - 1];
    }
}
