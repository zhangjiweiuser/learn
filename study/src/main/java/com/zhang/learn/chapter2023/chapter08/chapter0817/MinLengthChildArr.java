package com.zhang.learn.chapter2023.chapter08.chapter0817;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-17 11:20
 */
public class MinLengthChildArr {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3, 9};
        System.out.println(len(arr, 9));
        System.out.println(len2(arr, 9));
    }

    private static int len(int[] arr, int target) {
        if (arr.length == 1) {
            if (arr[0] >= target) {
                return 1;
            }
        }
        int min = Integer.MAX_VALUE;
        int i = 0, j = 1, len = arr.length, sum = arr[0];
        while (i <= j && j < len) {
            sum += arr[j];
            if (sum >= target) {
                min = Math.min(min, j - i + 1);
                if (min == 1) {
                    break;
                }
                while (i <= j && sum >= target) {
                    sum -= arr[i];
                    i++;
                    if (sum >= target) {
                        min = Math.min(min, j - i + 1);
                        if (min == 1) {
                            break;
                        }
                    }
                }
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private static int len2(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
