package com.zhang.learn.chapter2023.chapter03.chapter0319;

/**
 * 在一个1-N的数字上，有一个机器人，当在1位置时，只能向右移动，当在N位置时，只能向左移动，
 * 如果需要移动到终点E，当前位置在cur，移动步数为K，求一共有多少中走法
 */
public class WalkWay {
    public static void main(String[] args) {
        System.out.println(f1(5, 4, 4, 2));
        System.out.println(walkway2(5, 4, 4, 2));
    }

    /**
     * 暴利递归
     *
     * @param n 一共1-N个位置，固定参数
     * @param e 终点位置，固定参数
     * @param k 移动步数K，移动一次减1
     * @param s 起始位置
     */
    public static int f1(int n, int e, int k, int s) {
        if (k == 0) {
            return s == e ? 1 : 0;
        }
        if (s == 1) {
            return f1(n, e, k - 1, 2);
        }
        if (s == n) {
            return f1(n, e, k - 1, n - 1);
        }
        return f1(n, e, k - 1, s - 1) + f1(n, e, k - 1, s + 1);
    }

    /**
     * 记忆化搜索版本
     */
    public static int walkway2(int n, int e, int k, int s) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(n,e,k,s,dp);
    }

    public static int f2(int n, int e, int rest, int cur, int[][] dp) {
        System.out.println(rest+"--"+cur);
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        if(rest == 0){
            dp[rest][cur] = cur == e ? 1 : 0;
            return dp[rest][cur];
        }
        if (cur == 1) {
            dp[rest][cur] = f1(n, e, rest - 1, 2);
        } else if (cur == n) {
            dp[rest][cur] = f1(n, e, rest - 1, n - 1);
        } else {
            dp[rest][cur] = f1(n, e, rest - 1, cur - 1) + f1(n, e, rest - 1, cur + 1);
        }
        System.out.println(rest+"--"+cur+"--"+dp[rest][cur]);
        return dp[rest][cur];
    }
}
