package com.zhang.learn.chapter2023.chapter10.chapter1031;

import java.util.Arrays;

public class XuanZhuanErWeiShuZu {
    public static void main(String[] args) {
        int[][] num = {{1, 2, 3, 4}, {5, 6, 7, 8},{9,10,11,12}};
        int[][] ans = xuanZhuan(num);
        for(int[] t : ans){
            System.out.println(Arrays.toString(t));
        }
    }

    private static int[][] xuanZhuan(int[][] num) {
        int row = num.length;
        int col = num[0].length;
        int[][] ans = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][row-i-1] = num[i][j];
            }
        }

        return ans;
    }
}
