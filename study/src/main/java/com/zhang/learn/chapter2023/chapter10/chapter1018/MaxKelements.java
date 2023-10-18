package com.zhang.learn.chapter2023.chapter10.chapter1018;

public class MaxKelements {
    public static void main(String[] args) {
        int[] nums = {672579538,806947365,854095676,815137524};
        System.out.println(maxKelements(nums,3));
    }
    public static long maxKelements(int[] nums, int k) {
        int sum = 0;
        while(k > 0){
            int max = 0;
            int index = -1;
            for(int i=0;i<nums.length;i++){
                if(nums[i] > max){
                    max = nums[i];
                    index = i;
                }
            }
            sum += max;
            nums[index] = (int) Math.ceil((double) nums[index] / 3);
            k--;
        }
        return sum;
    }
}
