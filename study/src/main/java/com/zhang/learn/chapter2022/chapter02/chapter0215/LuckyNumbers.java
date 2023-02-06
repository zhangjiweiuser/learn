package com.zhang.learn.chapter2022.chapter02.chapter0215;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-02-15 11:03
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        LuckyNumbers luck = new LuckyNumbers();
        int[][] matrix = {{7,8},{1,2}};
        System.out.println(luck.luckyNumbers(matrix));
    }
    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int[] first = new int[row];
        for (int i = 0; i < row; i++) {
            first[i] = matrix[i][0];
        }

        for (int i = 0; i < row; i++) {
            int min = 0;
            for (int j = 1; j < col; j++) {
                if(matrix[i][j] < first[i]){
                    first[i] = matrix[i][j];
                    min = j;
                }
            }
            boolean flag = true;
            for(int j = 0;j<row;j++){
                if(matrix[j][min] > first[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result.add(first[i]);
            }
        }

        return result;
    }
}
