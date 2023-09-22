package com.zhang.learn.chapter2023.chapter09.chapter0919;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * 输入 = [1,3,-1,-3,5,3,6,7],k=3
 * 输出 = [3,3,5,5,6,7]
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-09-20 11:24
 */
public class MaxNum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxNum(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    private static int[] maxNum(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i-k+1,i]中选择最大值，只需要保证两点
            // 1. 队列头结点需要在[i-k+1,i]范围内，不符合要弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // 2. 既然是单调，就要保证每次放进去的数字要比末尾的都大，否则就弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            // 因为要单调，当i增长到第一个符合k范围的时候，没滑动一步都要将队列头节点放入结果
            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
