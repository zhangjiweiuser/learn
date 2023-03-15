package com.zhang.learn.chapter2023.chapter03.chapter0308;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-08 16:16
 */
public class Swap {
    public static void main(String[] args) {
        // 可以这样用的前提，是a,b地址不同
//        int a = 10;
//        int b = 20;
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println(a);
//        System.out.println(b);
//        jishuci();
        liangge();
    }

    private static void jishuci() {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int t = arr[0];
        for (int i = 1; i < arr.length; i++) {
            t = t ^ arr[i];
        }
        System.out.println(t);
    }

    private static void liangge() {
        System.out.println(2 ^ 8);
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 8};
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (~eor + 1);
        System.out.println(rightOne);
        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & onlyOne) == rightOne) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + "  --   " + (eor ^ onlyOne));
    }

    protected static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
