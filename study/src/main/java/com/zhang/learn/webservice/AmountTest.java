package com.zhang.learn.webservice;

import java.math.BigDecimal;

public class AmountTest {
    public static void main(String[] args) {
        int a = 106;
        System.out.println(a / 100.00);
        System.out.println(new BigDecimal(18089).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));
    }
}
