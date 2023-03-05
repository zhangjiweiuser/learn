package com.zhang.learn.chapter2023.chapter03.chapter0304;

import java.util.Arrays;

public class ArrSwap {
    public static void main(String[] args) {
//        arrSwap();
//        remove();
        remove2();
        int a= 0;
        System.out.println(a++);
        System.out.println(a);
        System.out.println(++a);
        System.out.println(a);
    }
    private static void arrSwap(){
        int[] a = {1,2,3,4,5,6};
        for (int i = 0; i < a.length / 2; i++) {
            int t = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = t;
        }
        System.out.println(Arrays.toString(a));
    }
    private static void remove(){
        int[] a = {1,2,1,5,1};
        int n = 1,j=0;
        for(int i=0;i<a.length;i++){
            if(a[i] != n){
                a[j++] = a[i];
            }
        }
        int[] t = new int[j];
        for(int i=0;i<j;i++){
            t[i] = a[i];
        }
        System.out.println(Arrays.toString(t));
    }

    private static void remove2(){
        // 删除相邻相同元素，如果有多个相邻，只保留1个，1，2，2，2，1-》1，2，1
        int[] a = {1,2,2,2,1,3};
        int j=0;
        for(int i=1;i<a.length;i++){
            if(a[i] != a[j]){
                a[++j] = a[i];
            }
        }
        int[] t = new int[j+1];
        for(int i=0;i<=j;i++){
            t[i] = a[i];
        }
        System.out.println(Arrays.toString(t));
    }
}
