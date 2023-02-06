package com.zhang.learn.chapter2021.chapter03.chapter0330;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/30 10:42
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1},{3}};
        System.out.println(searchMatrix(matrix, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1){
            return searchMatrix(matrix[0],target);
        }
        int left = 0;
        int right = matrix.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int[] midArr = matrix[mid];
            if (midArr[midArr.length - 1] < target) {
                left = mid + 1;
            } else if (midArr[0] > target) {
                right = mid - 1;
            } else {
                return searchMatrix(midArr, target);
            }
        }
        return false;
    }


    public static boolean searchMatrix(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int mid = 0;
        if(target < matrix[left] || target > matrix[right] || left > right){
            return false;
        }

        while (left <= right) {

            mid = (left + right) / 2;
            if (matrix[mid] > target) {
                right = mid - 1;
            } else if (matrix[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }

        }
        return false;
    }

}
