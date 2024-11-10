package com.zhang.learn.chapter2024.chapter02.chapter0205;

public class PaymentHandler extends OrderHandler {
    @Override
    void handleOrder(OrderRequest orderRequest) {
        System.out.println("Payment processed for order: " + orderRequest.getProductName() + "."+orderRequest.getPrice());
        String next = chain.get(orderRequest.getChannel()).get(type());
        if(next != null){
            RegisterCenter.getHandler(next).handleOrder(orderRequest);
        }
    }

    @Override
    String type() {
        RegisterCenter.register("payment",this);
        return "payment";
    }
}
