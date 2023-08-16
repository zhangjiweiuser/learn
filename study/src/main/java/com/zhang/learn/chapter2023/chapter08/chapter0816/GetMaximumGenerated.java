package com.zhang.learn.chapter2023.chapter08.chapter0816;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-16 16:46
 */
public class GetMaximumGenerated {
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(15));
    }
    public static int getMaximumGenerated(int n) {
        int[] nums = new int[n + 2];
        nums[0] = 0; nums[1] = 1;
        int t = 2;
        int max = 1;
        while (t <= n) {
            if (t % 2 == 0) {
                nums[t] = nums[t / 2];

            } else {
                nums[t] = nums[t / 2] + nums[t / 2 + 1];
            }
            if(nums[t] > max){
                max = nums[t];
            }
            t++;
        }
        return max;
    }
}
