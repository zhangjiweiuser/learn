package com.zhang.learn.chapter11.chapter1118;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/11/18 15:19
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int num = solution.canCompleteCircuit(gas, cost);
        System.out.println(num);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}
