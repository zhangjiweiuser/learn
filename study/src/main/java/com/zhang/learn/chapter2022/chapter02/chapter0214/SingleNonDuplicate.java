package com.zhang.learn.chapter2022.chapter02.chapter0214;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-14 14:55
 */
public class SingleNonDuplicate {
    public static void main(String[] args) {
        SingleNonDuplicate duplicate = new SingleNonDuplicate();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(duplicate.singleNonDuplicate(nums));
    }
    public int singleNonDuplicate(int[] nums) {
        int result = nums[0] ^ nums[1];
        for(int i=2;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
