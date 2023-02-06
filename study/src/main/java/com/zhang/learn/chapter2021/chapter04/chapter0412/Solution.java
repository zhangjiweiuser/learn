package com.zhang.learn.chapter2021.chapter04.chapter0412;

import java.util.Arrays;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/4/12 9:55
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if ("0".equals(numStr[0])) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : numStr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums));
    }
}
