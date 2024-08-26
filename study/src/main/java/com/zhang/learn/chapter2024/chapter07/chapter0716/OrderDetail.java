package com.zhang.learn.chapter2024.chapter07.chapter0716;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetail {

    private Integer period;

    private List<OrderItem> itemList;
}
