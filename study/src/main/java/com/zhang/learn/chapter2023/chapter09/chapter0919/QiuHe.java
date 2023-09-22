package com.zhang.learn.chapter2023.chapter09.chapter0919;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-19 14:10
 */
public class QiuHe {
    public static void main(String[] args) {
        System.out.println(add(3,11));
        System.out.println(add(15,11));
    }
    private static int add(int a,int b){
        int partSum = a ^ b;
        int carrySum = (a&b) << 1;
        while(carrySum > 0){
            int tmp = partSum ^ carrySum;
            carrySum =  (partSum & carrySum) << 1;
            partSum = tmp;
        }
        return partSum;
    }
}
