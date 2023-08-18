package com.zhang.learn.chapter2023.chapter08.chapter0818;

import java.util.HashMap;
import java.util.Map;

/**
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * @author zhangjiwei1
 * @description
 * @create 2023-08-18 10:50
 */
public class KuaiLeShu {
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(kuaiLe(19));
        System.out.println(kuaiLe(18));
    }
    private static boolean kuaiLe(int n){
        int t = n;
        if(map.get(n) != null){
            return false;
        }
        int sum = 0;
        while(n != 0){
            int g = n % 10;
            sum += g * g;
            n = n / 10;
        }
        if(sum == 1){
            return true;
        }else{
            map.put(t,1);
            return kuaiLe(sum);
        }
    }
}
