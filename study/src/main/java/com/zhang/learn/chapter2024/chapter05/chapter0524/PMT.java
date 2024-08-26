package com.zhang.learn.chapter2024.chapter05.chapter0524;

public class PMT {
 
    /**
     * 
     * 计算月供
     * 
     * @param rate
     *            年利率 年利率除以12就是月利率
     * @param nper
     *            贷款期数，单位月 该项贷款的付款总数。 
     * @param pv
     *            贷款金额,现值，或一系列未来付款的当前值的累积和，也称为本金。 
     * @return
     * 
     */
    public static double calculatePMT(double rate, double nper, double pv) {
        double v = (1 + (rate / 12));
        double t = (-(nper / 12) * 12);
        double result = (pv * (rate / 12)) / (1 - Math.pow(v, t));
        return result;
    }
 
    public static void main(String[] args) {
        System.out.println((calculatePMT(0.09, 12, 10000) * 12) / 10000 - 1);
        System.out.println((calculatePMT(0.085, 24, 10000) * 24) / 10000 - 1);
        System.out.println((calculatePMT(0.085, 36, 10000) * 36) / 10000 - 1);
    }
}