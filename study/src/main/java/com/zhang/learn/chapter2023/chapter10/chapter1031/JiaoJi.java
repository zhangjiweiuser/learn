package com.zhang.learn.chapter2023.chapter10.chapter1031;

import java.util.ArrayList;
import java.util.List;

public class JiaoJi {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 3, 5, 7};
        int[] num2 = {1, 1, 2, 2, 2, 2, 3, 3, 5, 7, 8};
        List<Integer> ans = jiaoJi(num1, num2);
        System.out.println(ans);
    }

    private static List<Integer> jiaoJi(int[] num1, int[] num2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        int m = num1.length, n = num2.length;
        while (i < m && j < n) {
            if (num1[i] == num2[j]) {
                ans.add(num1[i]);
                i++;
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
