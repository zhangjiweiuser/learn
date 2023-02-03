package com.zhang.learn.chapter10.chapter1030;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/30 14:32
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
    }

    public static int islandPerimeter(int[][] grid) {
        int total = 0;
        int together = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] a = grid[i];
            for (int j = 0; j < a.length; j++) {
                int b = a[j];
                if (b == 1) {
                    total++;
                    if (j > 0 && grid[i][j - 1] == 1) {
                        together++;
                    }

                    if (i > 0 && grid[i - 1][j] == 1) {
                        together++;
                    }

                }
            }
        }
        return total * 4 - together * 2;
    }

}
