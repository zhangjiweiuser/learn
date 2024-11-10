package com.zhang.learn.chapter2024.chapter02.chapter0205;

public class ChainTest {
    public static void main(String[] args) {
        OrderHandler stockChecker = new StockHandler();
        stockChecker.type();

        OrderHandler couponValidator = new CouponHandler();
        couponValidator.type();
        OrderHandler paymentProcessor = new PaymentHandler();
        paymentProcessor.type();
//        stockChecker.setSuccessor(couponValidator);
//        couponValidator.setSuccessor(paymentProcessor);

        OrderRequest order1 = new OrderRequest(1, "Product A", 90);
        OrderRequest order2 = new OrderRequest(1, "Product B", 60);
        OrderRequest order3 = new OrderRequest(2, "Product B", 120);

        stockChecker.handleOrder(order1);
        System.out.println("-------------");
        stockChecker.handleOrder(order2);
        System.out.println("-------------");
        stockChecker.handleOrder(order3);

    }
}
