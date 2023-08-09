package com.zhang.learn.chapter2023.chapter08.chapter0809.recursion;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-09 10:27
 */
public class Queen8 {
    int max = 8;
    int[] arr = new int[max];

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        // 依次放入皇后，并判断是否有冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n，放到该行的第一列
            arr[n] = i;
            // 判断当前放置第n个皇后到i列，判断是否冲突
            if(judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // arr[i] == arr[n] 说明在同一列
            // Math.abs(n-i) == Math.abs(arr[n] - arr[i]) 说明在同一斜线上
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
