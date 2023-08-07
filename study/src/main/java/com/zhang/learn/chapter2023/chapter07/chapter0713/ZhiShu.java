package com.zhang.learn.chapter2023.chapter07.chapter0713;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-07-13 17:03
 */
public class ZhiShu {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        for(int i= 101;i<200;i++){
            if(isZhiShu(i)){
                result.add(i);
            }
        }
        System.out.println(result);
    }
    private static boolean isZhiShu(int num){
        int n = (int) (Math.sqrt(num)+1);
        for(int i=2;i<=n;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
