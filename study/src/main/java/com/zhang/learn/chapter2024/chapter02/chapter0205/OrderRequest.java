package com.zhang.learn.chapter2024.chapter02.chapter0205;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderRequest {
    private int channel;
    private String productName;
    private int price;
}
