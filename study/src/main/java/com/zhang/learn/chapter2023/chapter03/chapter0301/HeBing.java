package com.zhang.learn.chapter2023.chapter03.chapter0301;

import java.util.Arrays;

public class HeBing {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 13, 15, 89};
        int[] b = {1, 2, 4, 6, 8, 10, 12, 45};
        int i = 0, j = 0, t = 0;
        int[] result = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[t++] = a[i++];
            } else {
                result[t++] = b[j++];
            }
        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(t);
        if (i < a.length) {
            System.arraycopy(a, i, result, t, a.length - i);
        }
        if (j < b.length) {
            System.arraycopy(b, j, result, t, b.length - j);
        }
        System.out.println(Arrays.toString(result));
    }
}
