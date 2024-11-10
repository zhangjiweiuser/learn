package com.zhang.learn.chapter2024.chapter02.chapter0205;

public class CouponHandler extends OrderHandler {
    @Override
    void handleOrder(OrderRequest orderRequest) {
        if (orderRequest.getProductName().equals("Product B") && orderRequest.getPrice() >= 50) {
            System.out.println("Coupon validated. Order for " + orderRequest.getProductName() + " approved.");
        } else {
            String next = chain.get(orderRequest.getChannel()).get(type());
            if (next != null) {
                RegisterCenter.getHandler(next).handleOrder(orderRequest);
            }
        }
    }

    @Override
    String type() {
        RegisterCenter.register("coupon", this);
        return "coupon";
    }
}
