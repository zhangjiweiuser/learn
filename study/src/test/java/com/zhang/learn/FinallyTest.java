package com.zhang.learn;

import java.time.LocalDate;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/12/31 9:27
 */
public class FinallyTest {
    public static void main(String[] args) {
//        fin();
        System.out.println(days());
    }

    private static long days(){
        LocalDate endDate = LocalDate.of(2019,01,01);
        return endDate.toEpochDay();
    }

    private static int fin(){
        try{
            int i = 1/0;
        }catch (Exception e){
            System.out.println("1111111111");
            return 1;
        }finally {
            System.out.println("22222222");
            return 2;
        }
    }
}
