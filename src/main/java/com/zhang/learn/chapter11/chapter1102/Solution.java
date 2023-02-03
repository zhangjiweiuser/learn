package com.zhang.learn.chapter11.chapter1102;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/2 12:56
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {3};
        int[] arr = solution.intersection(nums1, nums2);
        for(int a : arr){
            System.out.println(a);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int n : nums1) {
            nums1Map.put(n, n);
        }
        for (int n : nums2) {
            if (null != nums1Map.get(n)) {
                result.add(n);
            }
        }
        int[] arr = new int[result.size()];
        Iterator<Integer> it = result.iterator();
        int i=0;
        while (it.hasNext()){
            arr[i++] = it.next();
        }

        return arr;
    }
}
