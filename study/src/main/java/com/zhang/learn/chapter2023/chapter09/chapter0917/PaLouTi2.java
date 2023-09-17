package com.zhang.learn.chapter2023.chapter09.chapter0917;

import java.util.Arrays;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 */
public class PaLouTi2 {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(money(cost));
    }

    public static int money(int[] cost) {
        int[] dp = new int[cost.length+1];
        for (int i = 2; i <= cost.length; i++) {
            int c = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

            dp[i] = c;
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];

    }
}
