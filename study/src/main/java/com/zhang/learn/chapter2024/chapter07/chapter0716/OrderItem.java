package com.zhang.learn.chapter2024.chapter07.chapter0716;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderItem {
    private String feeNo;
    private Integer amount;
}
