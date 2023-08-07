package com.zhang.learn.chapter2023.chapter07.chapter0713;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-07-13 19:00
 */
public class ArrSearch {
    public static void main(String[] args) {
        int target = 7;
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(target,arr));
    }

    public static boolean find(int target, int[][] array) {
        int row = 0,col = array[0].length-1;
        while(row < array.length && col >= 0){
            if(target == array[row][col]){
                return true;
            } else if (target > array[row][col]) {
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
