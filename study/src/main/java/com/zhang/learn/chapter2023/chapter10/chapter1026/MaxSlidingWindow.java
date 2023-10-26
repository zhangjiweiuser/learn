package com.zhang.learn.chapter2023.chapter10.chapter1026;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 输入 nums=[1,3,-1,-3,5,3,6,7] ,k=3
 * 输出 [3,3,5,5,6,7]
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(res));
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);
//        System.out.println(deque.peek());
//        System.out.println(deque.peekLast());
        System.out.println(deque.poll());
        System.out.println(deque.pollLast());
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        // 用于存放数组下标
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);

            if(i >= k-1){
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
