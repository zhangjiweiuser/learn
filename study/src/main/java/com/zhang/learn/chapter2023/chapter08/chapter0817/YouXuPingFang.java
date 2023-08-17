package com.zhang.learn.chapter2023.chapter08.chapter0817;

import java.util.Arrays;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-17 10:45
 */
public class YouXuPingFang {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pingFang2(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(pingFang2(new int[]{0,3,10,11,12})));
        System.out.println(Arrays.toString(pingFang2(new int[]{-11,-9,-8,-7,0})));
    }

    private static int[] pingFang(int[] arr) {
        // 1. 找到第一个非0的位置，默认在第0位置，如果找不到，则表明全部都是负数，则从后向前输出即可
        // 如果找到了，则依当前位置开始，分别向前后进行遍历，知道位置0或结尾，然后将剩下的树依次平方输出
        int index = 0;
        // 定义变量ans，用于存放输出结果
        int[] ans = new int[arr.length];
        // 定义变量t，用于存放将要输出到ans结果的下标
        int t = 0;

        if (arr[0] < 0 && arr[arr.length - 1] > 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) {
                    index = i;
                    break;
                }
            }
        }
        if (index > 0) {
            // 定义向左，向右下标
            int left = index - 1, right = index;
            while (left >= 0 && right < arr.length) {
                if (arr[left] * arr[left] < arr[right] * arr[right]) {
                    ans[t++] = arr[right] * arr[right];
                    right++;
                } else {
                    ans[t++] = arr[left] * arr[left];
                    left--;
                }
            }

            while (left >= 0) {
                ans[t++] = arr[left] * arr[left];
                left--;
            }
            while (right < arr.length) {
                ans[t++] = arr[right] * arr[right];
                right++;
            }
        } else {
            if (arr[0] >= 0) {
                for (int a : arr) {
                    ans[t++] = a * a;
                }
            } else {
                for (int a = arr.length - 1; a >= 0; a--) {
                    ans[t++] = arr[a] * arr[a];
                }
            }
        }
        return ans;
    }

    private static int[] pingFang2(int[] arr) {
        int left = 0,right = arr.length-1;
        int[] ans = new int[arr.length];
        int t=ans.length-1;
        while(left <= right){
            if(arr[left] * arr[left] < arr[right] * arr[right]){
                ans[t--] = arr[right] * arr[right];
                right--;
            }else{
                ans[t--] = arr[left] * arr[left];
                left++;
            }
        }
        return ans;
    }
}
