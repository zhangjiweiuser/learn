package com.zhang.learn.chapter2023.chapter08.chapter0814;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-14 16:22
 */
public class ThirdMax {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(thirdMax(arr));
    }
    public static int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == Integer.MIN_VALUE){
                flag = true;
            }
            if(nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
            }else if(nums[i] < first && nums[i] > second){
                third = second;
                second = nums[i];
            }else if(nums[i] < second && nums[i] > third){
                third = nums[i];
            }
        }
        if(flag && second == third && third == Integer.MIN_VALUE){
            return first;
        }
        if(!flag && third == Integer.MIN_VALUE){
            return first;
        }
        return third;
    }
}
