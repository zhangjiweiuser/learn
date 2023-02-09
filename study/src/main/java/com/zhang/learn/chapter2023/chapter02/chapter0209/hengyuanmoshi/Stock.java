package com.zhang.learn.chapter2023.chapter02.chapter0209.hengyuanmoshi;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-09 9:21
 */
@Data
@NoArgsConstructor
public class Stock {
    private int total;
    private int used;

    public Stock(int total, int used) {
        this.total = total;
        this.used = used;
    }
}
