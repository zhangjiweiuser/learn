package com.zhang.learn.chapter11.chapter1103;

/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/3 9:42
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(solution.validMountainArray(a));
    }

    public boolean validMountainArray(int[] A) {
        if (null == A || A.length < 3) {
            return false;
        }
        int t = 1;
        if (A[0] > A[1]) {
            return false;
        }
        for (int i = 0, j = A.length; i < j; i++) {
            if (A[i] == A[t]) {
                return false;
            }
            if (A[i] < A[t] && t < j - 1) {
                t++;

            } else {
                t--;
                break;
            }
        }

        for (int i = t + 1, j = A.length; i < j; i++) {
            if (A[i] == A[t]) {
                return false;
            }
            if (A[i] < A[t] && t < j - 1) {
                t++;

            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validMountainArray2(int[] A) {
        int t = A.length;
        int i = 0;
        // 先递增
        while (i + 1 < t && A[i] < A[i + 1]) {
            i++;
        }
        // 最高点不能是数组的第一个或者最后一个位置
        if (i == 0 || i == t - 1) {
            return false;
        }
        // 再递减
        while (i + 1 < t && A[i] > A[i + 1]) {
            i++;
        }
        return i == t - 1;
    }

    /**
     * 双指针，先从左边开始，找到最大值，再从右边，找到最大值，看两个最大值坐标是不是一样
     *
     * @param A
     * @return
     */
    public boolean validMountainArray3(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        // 先从左边找，找到最大值
        while (left + 1 < len && A[left] < A[left + 1]) {
            left++;
        }
        // 从右边找到最大值
        while (right > 0 && A[right - 1] > A[right]) {
            right--;
        }
        // 判断从左边和从右边找到的最大值坐标是否一样
        return left > 0 && right < len - 1 && left == right;
    }
}
