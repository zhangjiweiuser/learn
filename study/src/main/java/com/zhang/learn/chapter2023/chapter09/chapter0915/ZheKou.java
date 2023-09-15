package com.zhang.learn.chapter2023.chapter09.chapter0915;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-09-15 17:41
 */
public class ZheKou {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Double[] arr = new Double[count+2];
        int i = 0;
        double originTotal = 0;
        double zhekou = 0;

        // 注意 hasNext 和 hasNextLine 的区别
        while (i < count) { // 注意 while 处理多个 case
            double a = in.nextDouble();
            double b = in.nextDouble();
            if(a < b){
                System.out.println("error");
                return;
            }
            originTotal += a;
            zhekou += b;
            i++;
        }
        double mianjian = in.nextDouble();
        DecimalFormat format = new DecimalFormat("#.00");
        if(mianjian < originTotal){
            System.out.println(format.format(zhekou));
        }else{
            double manjianzhekou = in.nextDouble();
            if(manjianzhekou > zhekou){
                System.out.println(manjianzhekou);
            }else{

                System.out.println(format.format(zhekou));
            }
        }
    }
}
