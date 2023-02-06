package com.zhang.learn.chapter2021.chapter03.chapter0330;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/30 9:28
 */
public class ChongFu {
    public static void main(String[] args) {

        System.out.println(chongfu(new int[]{1,2,0,4,3,2}));
        System.out.println(chongfu(new int[]{1,2,3,4,3,2}));
    }

    private static int chongfu(int[] nums) {
        int num = 0;
        while (num < nums.length) {
            if (num == nums[num]) {
                num++;
                continue;
            }
            if (nums[num] == nums[nums[num]]) {
                return nums[num];
            }
            int tem = nums[num];
            nums[num] = nums[tem];
            nums[tem] = tem;

        }
        return -1;
    }
}
