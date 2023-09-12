package com.zhang.learn.chapter2023.chapter09.chapter0906;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 给定一个数组，以及一个目标值，求总和大于目标值需要的最少数个数
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-09-06 16:53
 */
public class MinArr {
    public static void main(String[] args) {
        int[] arr = generate(20);
        System.out.println(Arrays.toString(arr));

        System.out.println(minArr(arr,16));
    }

    private static int minArr(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0, sum = 0; j < arr.length; j++) {
            sum += arr[j];
            while (sum - arr[i] >= target) {
                sum -= arr[i++];
            }
            if (sum >= target) {
                min = Math.min(min, j - i + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private static int[] generate(int num) {
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        return arr;
    }
}
