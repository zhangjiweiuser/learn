package com.zhang.learn.chapter2023.chapter10.chapter1013;

/**
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 * 示例 1：
 * 输入：n = 7
 * 输出：21
 * 解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21 。
 */
public class SumOfMultiples {
    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
        System.out.println(sumOfMultiples(10));
        System.out.println(sumOfMultiples(9));
    }

    public static int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
