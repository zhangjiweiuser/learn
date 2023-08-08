package com.zhang.learn.chapter2023.chapter08.chapter0809.recursion;

/**
 * 1 1 1 1 1 1 1
 * 1 0 0 0 0 0 1
 * 1 0 0 0 0 0 1
 * 1 1 1 0 0 0 1
 * 1 0 0 0 0 0 1
 * 1 0 0 0 0 0 1
 * 1 0 0 0 0 0 1
 * 1 1 1 1 1 1 1
 * 给定一个这样的棋盘，看是否能从1，1走到6，5位置，左上角为0，0
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 1; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("初始墙");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println("是否走通");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 围墙
     * @param i   从哪个位置开始走
     * @param j   从哪个位置开始走
     * @return 是否有通路
     * map[i][j] == 0，表示还从来没走过，1表示是墙，2表示走过，可以走通，3 表示，走过，但是此路不通
     * 按照下->右->上->左的策略去走
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {

                map[i][j] = 2; // 先将此位置设置为2，代表走过
                if (setWay(map, i + 1, j)) {// 往下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//往右走
                    return true;
                } else if (setWay(map, i - 1, j)) {// 往上走
                    return true;
                } else if (setWay(map, i, j - 1)) {// 往左走
                    return true;
                } else {
                    map[i][j] = 3;// 说明走不通
                    return false;
                }
            } else {
                // 此时，说明map[i][j] = 1,2,3,此时都不通
                return false;
            }
        }
    }
}
