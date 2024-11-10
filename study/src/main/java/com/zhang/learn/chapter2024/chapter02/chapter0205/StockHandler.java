package com.zhang.learn.chapter2024.chapter02.chapter0205;

public class StockHandler extends OrderHandler {
    @Override
    void handleOrder(OrderRequest orderRequest) {
        if (orderRequest.getProductName().equals("Product A") && orderRequest.getPrice() <= 100) {
            System.out.println("Stock available. Order for " + orderRequest.getProductName() + " approved.");
        } else {

            String next = chain.get(orderRequest.getChannel()).get(type());
            if(next != null){
                RegisterCenter.getHandler(next).handleOrder(orderRequest);
            }
        }
    }

    @Override
    String type() {
        RegisterCenter.register("stock",this);
        return "stock";
    }
}
