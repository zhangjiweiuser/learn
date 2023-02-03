package com.zhang.learn.chapter08.chapter0825;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/25 17:29
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        int[] prices2 = {1,2,30,1,1};
        System.out.println(maxProfit(prices2));
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices3));

    }

    public static int maxProfit(int[] prices) {
        int sum = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
            }

        }

        return sum;
    }
}
