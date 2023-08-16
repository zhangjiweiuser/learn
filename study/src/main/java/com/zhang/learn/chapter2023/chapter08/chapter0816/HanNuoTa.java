package com.zhang.learn.chapter2023.chapter08.chapter0816;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-16 14:54
 */
public class HanNuoTa {
    public static void main(String[] args) {
        hanNuoTa(2, 'a', 'b', 'c');
    }

    private static void hanNuoTa(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            // 如果num >= 2，我们这里总是可以看做是两个盘，1.最下边的一个盘，2. 上面的所有盘
            // 1. 先把最上面的所有盘，从A-B,移动的过程中会用到C
            hanNuoTa(num - 1, a, c, b);
            // 2。 把最下面的盘A-C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            // 3. 把B塔上的所有盘从B-C，移动过程中会用到a
            hanNuoTa(num - 1, b, a, c);
        }
    }
}
