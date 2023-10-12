package com.zhang.learn.chapter2023.chapter10.chapter1010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SplitNum {
    public static void main(String[] args) {
        System.out.println(splitNum(4325));
        System.out.println(splitNum(687));
        System.out.println(splitNum2(4325));
        System.out.println(splitNum2(687));
    }

    public static int splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            if (num % 10 != 0) {
                list.add(num % 10);
            }
            num = num / 10;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        Collections.sort(list);
        int num1 = list.get(0);
        int num2 = list.get(1);
        int t = 2;
        for (int i = 2; i < list.size() - 1; i += 2) {
            num1 = num1 * 10 + list.get(i);
            num2 = num2 * 10 + list.get(i + 1);
            t += 2;
        }
        if (t < list.size()) {
            num1 = num1 * 10 + list.get(list.size() - 1);
        }
        return num1 + num2;
    }

    public static int splitNum2(int num) {
        char[] s = (String.valueOf(num)).toCharArray();
        Arrays.sort(s);
        int[] ans = new int[2];
        for(int i = 0;i<s.length;i++){
            ans[i&1] = ans[i&1]*10 + s[i] - '0';
        }
        return ans[0] + ans[1];
    }
}
