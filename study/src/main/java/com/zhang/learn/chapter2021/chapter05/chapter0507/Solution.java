package com.zhang.learn.chapter2021.chapter05.chapter0507;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/5/7 10:19
 */
public class Solution {
    // 给你两个整数，n 和 start 。
    //
    //数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
    //
    //请返回 nums 中所有元素按位异或（XOR）后得到的结果。

    public int xorOperation(int n, int start) {
        if (n <= 0) {
            return start;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result ^ (start + 2 * i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.xorOperation(4, 3));
    }
}
