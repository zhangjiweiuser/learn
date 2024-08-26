package com.zhang.learn.chapter2024.chapter05.chapter0524;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.BindException;

public class FinanceUtil {
    public static void main(String[] args) {
//        for(int i=566;i<156000;i+=452){
//            System.out.println(-1*Finance.pmt(0.01998,12,i));
//            System.out.println(pmt(new BigDecimal("0.23976"),12,new BigDecimal(i)));
//            System.out.println("=======================");
//        }
        System.out.println(-1 * Finance.pmt(0.01998, 12, 1008));
        System.out.println(pmt(new BigDecimal("0.01998"), 12, new BigDecimal(1008)));
        System.out.println("------------");

        System.out.println(Finance.fv(0.01998, 1, 95.30, 1008));
        System.out.println(fv(new BigDecimal("0.01998"), 1, new BigDecimal("95.30"), new BigDecimal(1008)));
        System.out.println("------------");
//        for(int i=1;i<=12;i++){
//            System.out.println(-1*Finance.ipmt(0.01998,i,12,1008));
//            System.out.println(ipmt(new BigDecimal("0.23976"),i,12,new BigDecimal("1008") ));
//            System.out.println("===========");
//        }
        double amount1= 566;
        BigDecimal amount2 = new BigDecimal("566");
        for (int i = 1; i <= 12; i++) {
            double ipmt1 = -1 * Finance.ipmt(0.01998, i, 12, amount1);
            BigDecimal ipmt2 = ipmt(new BigDecimal("0.01998"), i, 12,amount2 );
//            System.out.println(ipmt1);
//            System.out.println(ipmt2);


            double ppmt1 = -1 * Finance.ppmt(0.01998, i, 12, amount1);
            System.out.println(ppmt1);
            BigDecimal ppmt2 = ppmt(new BigDecimal("0.01998"), i, 12, amount2);
            System.out.println(ppmt2);

            System.out.println("pmt1:"+(ppmt1 + ipmt1));
            System.out.println("pmt2:"+(ppmt2.add(ipmt2)));
            System.out.println("================="+i);
        }
    }

    private static BigDecimal pmt(BigDecimal monthRate, int period, BigDecimal amount) {
        BigDecimal rate = BigDecimal.ONE.add(monthRate);
        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i < period; i++) {
            result = result.multiply(rate).setScale(20, RoundingMode.HALF_DOWN);
        }
        return amount.multiply(result).multiply(monthRate).multiply(new BigDecimal("-1"))
                .divide(result.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_DOWN).multiply(new BigDecimal("-1"));
    }

    private static BigDecimal fv(BigDecimal monthRate, int nper, BigDecimal pmt, BigDecimal pv) {
//        System.out.println("yearRate:"+yearRate);
//        System.out.println("nper:"+nper);
//        System.out.println("pmt:"+pmt);
//        System.out.println("pv:"+pv);
        BigDecimal rate = BigDecimal.ONE.add(monthRate);
        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i < nper; i++) {
            result = result.multiply(rate).setScale(20, RoundingMode.HALF_DOWN);
        }
//        System.out.println("ttt:" + result);
        BigDecimal p1 = pv.multiply(result);
        BigDecimal p2 = pmt.multiply(result.subtract(BigDecimal.ONE)).divide(monthRate, 8, RoundingMode.HALF_DOWN);
        return BigDecimal.ZERO.subtract(p1).subtract(p2);
    }

    private static BigDecimal ipmt(BigDecimal monthRate, int curPeriod, int period, BigDecimal amount) {

        BigDecimal pmt = pmt(monthRate, period, amount).multiply(new BigDecimal("-1"));
        return fv(monthRate, curPeriod - 1, pmt, amount)
                .multiply(monthRate)
                .multiply(new BigDecimal("-1")).setScale(2, RoundingMode.HALF_DOWN);
    }

    static public BigDecimal ppmt(BigDecimal monthRate, int per, int nper, BigDecimal pv) {
        return pmt(monthRate, nper, pv).subtract(ipmt(monthRate, per, nper, pv));
    }
}
