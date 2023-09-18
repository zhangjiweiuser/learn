package com.zhang.learn.chapter2023.chapter09.chapter0918;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-18 15:21
 */
public class QiuHe {
    public static void main(String[] args) {
        System.out.println(getSum(3,11));
    }
    private static int getSum(int a,int b){
        int partSum = a ^ b; // 异或运算获取不进位的和
        int carrySum = (a & b) << 1; // 与运算后左移一位代表进位部分
        // 重复上面的运算，直到进位为0
        while(carrySum != 0){
            int tmp = partSum ^ carrySum;
            carrySum = (partSum & carrySum) << 1;
            partSum = tmp;
        }
        return partSum;
    }
}
