package com.zhang.learn.chapter2023.chapter08.chapter0829;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-29 14:39
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }
}
