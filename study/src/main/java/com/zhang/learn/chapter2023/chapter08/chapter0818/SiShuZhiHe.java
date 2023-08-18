package com.zhang.learn.chapter2023.chapter08.chapter0818;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 15:19
 */
public class SiShuZhiHe {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> list = qiuhe(arr, 0);
        for (List<Integer> a : list) {
            System.out.println(a);
        }
    }

    private static List<List<Integer>> qiuhe(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 先对其进行排序
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                break;
            }
            // 说明两个数一样，前面的处理过，后面的就不需要处理了
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        while (left < right && arr[right] == arr[right - 1]) {
                            right--;
                        }
                        while (left < right && arr[left] == arr[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
