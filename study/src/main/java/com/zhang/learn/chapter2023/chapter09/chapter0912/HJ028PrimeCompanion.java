package com.zhang.learn.chapter2023.chapter09.chapter0912;

import java.util.ArrayList;
import java.util.List;

/**
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，
 * 从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，
 * 如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 * <p>
 * 输入:
 * <p>
 * 有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
 * <p>
 * 输出:
 * <p>
 * 输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-09-12 16:58
 */
public class HJ028PrimeCompanion {
    public static void main(String[] args) {
        int[] arr = {2,5,6,13};
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (int a : arr) {
            if (isEven(a)) {
                evenList.add(a);
            } else {
                oddList.add(a);
            }
        }
        int size = evenList.size();
        int count = 0;
        // 已经匹配的数的伴侣
        int[] evensMatch = new int[size];
        for (int odd : oddList) {
            int[] used = new int[size];
            if (find(odd, evenList, used, evensMatch)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean find(int odd, List<Integer> evens, int[] used, int[] evensMatch) {
        // 检查当前传入的奇数能否与偶数哪些数匹配
        for (int i = 0; i < evens.size(); i++) {
            // 如果当前偶数与传入的奇数匹配，并且当前偶数还没有匹配过奇数
            if (isPrime(odd + evens.get(i)) && used[i] == 0) {
                used[i] = 1;
                if (evensMatch[i] == 0 || find(evensMatch[i], evens, used, evensMatch)) {

                    evensMatch[i] = odd;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
