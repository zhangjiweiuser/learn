package com.zhang.learn.chapter2023.chapter10.chapter1026;

public class PingFangGen {
    private static double wucha = 0.001;
    public static void main(String[] args) {
        System.out.println(pingfang(3,0,3));
    }
    private static double pingfang(double t,double left,double right){
        double mid = left + (right - left) / 2;
        double m = mid * mid - t;
        if(Math.abs(m) < wucha){
            return mid;
        }else if(m < 0){
            return pingfang(t,mid,right);
        }else{
            return pingfang(t,left,mid);
        }
    }
}
