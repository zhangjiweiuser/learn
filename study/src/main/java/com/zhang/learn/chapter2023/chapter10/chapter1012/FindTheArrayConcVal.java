package com.zhang.learn.chapter2023.chapter10.chapter1012;

public class FindTheArrayConcVal {
    public static void main(String[] args) {
        int[] nums = {5, 14, 13, 8, 12};
        System.out.println(findTheArrayConcVal(nums));
    }

    public static long findTheArrayConcVal(int[] nums) {
        long sum = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int l = nums[left++];
            int r = nums[right--];
            for(int t = r;t>0;t /= 10){
                l *= 10;
            }
            sum += l + r;
        }
        if (left == right) {
            sum += nums[left];
        }
        return sum;
    }
}
