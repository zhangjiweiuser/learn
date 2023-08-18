package com.zhang.learn.chapter2023.chapter08.chapter0818;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 12:21
 */
public class SanShuZhiHe {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,2,-1,-1,2,2,2-1,-4};
        int[][] res = qiuhe(arr);
        if(null != res){
            for(int[] a : res){
                System.out.println(Arrays.toString(a));
            }
        }
    }

    private static int[][] qiuhe(int[] arr) {
        List<int[]> list = new ArrayList<>();
        // 先进行排序，如果满足，例如-1,0,1,2,-1,-4-》-4,-1,-1,0,1,2
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > 0) {
                break;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    while(left < right && arr[right] == arr[right-1]){
                        right--;
                    }
                    while(left < right && arr[left] == arr[left+1]){
                        left++;
                    }
                    int[] res = new int[]{arr[i], arr[left], arr[right]};
                    list.add(res);

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        if(list.size() > 0){
            int[][] res = new int[list.size()][3];
            for(int i=0;i<res.length;i++){
                res[i] = list.get(i);
            }
            return res;
        }
        return null;
    }
}
