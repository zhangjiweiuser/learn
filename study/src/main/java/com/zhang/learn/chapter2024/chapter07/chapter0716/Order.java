package com.zhang.learn.chapter2024.chapter07.chapter0716;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private String orderId;

    private List<OrderDetail> detailList;
}
