package com.zhang.learn.chapter2024.chapter05.chapter0524;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoDto {
    private String name;
    private BigDecimal amount;
}
