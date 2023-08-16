package com.zhang.learn.chapter2023.chapter08.chapter0816;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-16 12:13
 */
public class MaxProductDifference {
    public static void main(String[] args) {
        int[] arr = {1,6,7,5,2,4,10,6,4};
        System.out.println(maxProductDifference(arr));
    }
    public static int maxProductDifference(int[] nums) {
        int maxf = Integer.MIN_VALUE;
        int maxs = Integer.MIN_VALUE;
        int minf = Integer.MAX_VALUE;
        int mins = Integer.MAX_VALUE;
        for(Integer n : nums){
            if(n > maxf){
                maxs = maxf;
                maxf = n;
            }else if(n > maxs){
                maxs = n;
            }
            if(n < minf){
                mins = minf;
                minf = n;
            }else if(n < mins){
                mins = n;
            }
        }
        return maxf * maxs - minf * mins;
    }
}
