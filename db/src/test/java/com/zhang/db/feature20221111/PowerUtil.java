package com.zhang.db.feature20221111;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2022-11-11 16:22
 */
public class PowerUtil {
    public static void main(String[] args) {
//        System.out.println(power(2,10));
//        System.out.println(power(2,11));
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        System.out.println("summaryId:"+ids);
    }

    public static int power(int x,int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        int y = n % 2 ;
        int t = n / 2;
        if(y == 1){
            return power(x,t) * power(x,t) * x;
        }else{
            return power(x,t) * power(x,t);
        }
    }
}
