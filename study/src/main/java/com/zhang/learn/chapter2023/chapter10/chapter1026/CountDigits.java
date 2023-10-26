package com.zhang.learn.chapter2023.chapter10.chapter1026;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 * 示例 1：
 * 输入：num = 7
 * 输出：1
 * 解释：7 被自己整除，因此答案是 1 。
 * 示例 2：
 * 输入：num = 121
 * 输出：2
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * 示例 3：
 * 输入：num = 1248
 * 输出：4
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 */
public class CountDigits {
    public static void main(String[] args) {
        System.out.println(countDigits(7));
        System.out.println(countDigits(121));
        System.out.println(countDigits(1248));
    }

    public static int countDigits(int num) {
        Set<Integer> can = new HashSet<>();
        Set<Integer> not = new HashSet<>();
        int ans = 0;
        int t = num;
        while (t > 0) {
            int m = t % 10;
            if (m == 0) {
                not.add(m);
            } else {
                if(can.contains(m)){
                    ans++;
                } else if (!can.contains(m) && !not.contains(m)) {
                    if (num % m == 0) {
                        can.add(m);
                        ans++;
                    } else {
                        not.add(m);
                    }
                }
            }
            t = t / 10;
        }
        return ans;
    }
}
