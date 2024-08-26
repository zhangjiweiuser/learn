package com.zhang.learn.chapter2024.chapter06.chapter0606;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {

    @Test
    public void test() {
//        System.out.println(inDark("23:00:00","02:00:00","23:00:00"));
//        System.out.println(inDark("23:00:00","02:00:00","23:20:00"));
//        System.out.println(inDark("23:00:00","02:00:00","01:20:00"));
//        System.out.println(inDark("23:00:00","02:00:00","02:00:00"));
//        System.out.println(inDark("23:00:00","02:00:00","12:20:00"));
//        System.out.println(inDark("23:00:00","02:00:00","02:20:00"));
//        long start2 = System.currentTimeMillis();
//        for(int i=0;i<100;i++){
//            boolean t1= inDark2("00:00:00", "02:00:00", "00:00:00");
//            boolean t2= inDark2("00:00:00", "02:00:00", "01:20:00");
//            boolean t3= inDark2("00:00:00", "02:00:00", "02:00:00");
//            boolean t4= inDark2("00:00:00", "02:00:00", "02:20:00");
//            boolean t5= inDark2("00:00:00", "02:00:00", "05:20:00");
//        }
//
//        long end2 = System.currentTimeMillis();
//        System.out.println("时间2="+(end2 - start2));
//        long start1 = System.currentTimeMillis();
//        for(int i=0;i<100;i++){
//            boolean t1= inDark("00:00:00", "02:00:00", "00:00:00");
//            boolean t2= inDark("00:00:00", "02:00:00", "01:20:00");
//            boolean t3= inDark("00:00:00", "02:00:00", "02:00:00");
//            boolean t4= inDark("00:00:00", "02:00:00", "02:20:00");
//            boolean t5= inDark("00:00:00", "02:00:00", "05:20:00");
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println("时间1="+(end1 - start1));
//
//        long start3 = System.currentTimeMillis();
//        for(int i=0;i<100;i++){
//            boolean t1= inDark3("00:00:00", "02:00:00", "00:00:00");
//            boolean t2= inDark3("00:00:00", "02:00:00", "01:20:00");
//            boolean t3= inDark3("00:00:00", "02:00:00", "02:00:00");
//            boolean t4= inDark3("00:00:00", "02:00:00", "02:20:00");
//            boolean t5= inDark3("00:00:00", "02:00:00", "05:20:00");
//        }
//        long end3 = System.currentTimeMillis();
//        System.out.println("时间3="+(end3 - start3));
        boolean t0= inDark3("00:00:00", "04:00:00", "22:00:00");
        boolean t1= inDark3("00:00:00", "04:00:00", "23:50:00");
        boolean t2= inDark3("00:00:00", "04:00:00", "00:00:00");
        boolean t3= inDark3("00:00:00", "04:00:00", "01:00:00");
        boolean t4= inDark3("00:00:00", "04:00:00", "04:00:00");
        boolean t5= inDark3("00:00:00", "04:00:00", "20:20:00");
        System.out.println(t0);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);

//        long start4 = System.currentTimeMillis();
//        for(int i=0;i<100;i++){
//            boolean t11= inDark4(200000, 230000, 0);
//            boolean t12= inDark4(200000, 230000, 200000);
//            boolean t13= inDark4(200000, 230000, 210000);
//            boolean t14= inDark4(200000, 230000, 220000);
//            boolean t15= inDark4(200000, 230000, 230000);
//            boolean t16= inDark4(200000, 230000, 233000);
//        }
//        long end4 = System.currentTimeMillis();
//        System.out.println("时间4="+(end4 - start4));
    }

    private boolean inDark(String start, String end, String currTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime s = LocalTime.parse(start, formatter);
        LocalTime e = LocalTime.parse(end, formatter);
        LocalTime now = LocalTime.parse(currTime, formatter);
        // 1 - 10
        if (s.isBefore(e)) {
            return !s.isAfter(now) && !e.isBefore(now);
        } else {
//            System.out.println("=====");
            // 23 - 4
            return s.equals(now) || s.isBefore(now) || e.equals(now) || e.isAfter(now);
        }
    }

    private boolean inDark2(String start, String end, String currTime) {
        int s = Integer.parseInt(start.replace(":",""));
        int e = Integer.parseInt(end.replace(":",""));
        int now = Integer.parseInt(currTime.replace(":",""));
        if(s < e){
            return now >= s &&  now <= e;
        }else{
            return now >= s || now <= e;
        }
    }

    public static boolean  inDark3(String start, String end, String givenTime) {
        // 判断给定时间是否在范围内 0 1 3
        if (start.compareTo(end) < 0) {
            return (givenTime.compareTo(start) >= 0 ) && ( givenTime.compareTo(end) <= 0 );
        } else {
            // 23:00:00     02:00:00  02:20:00
            return (givenTime.compareTo(start) >= 0 ) || ( givenTime.compareTo(end) <= 0 );
        }
    }

    public static boolean inDark4(int s, int e, int now) {
        // 判断给定时间是否在范围内 0 1 3
        if(s < e){
            return now >= s &&  now <= e;
        }else{
            return now >= s || now <= e;
        }
    }
}
