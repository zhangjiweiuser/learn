package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.ceiling;

import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.Matter;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 16:55
 */
public class LevelOneCeiling implements Matter {
    @Override
    public String scene() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "装修公司自带";
    }

    @Override
    public String model() {
        return "一级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal("260");
    }

    @Override
    public String desc() {
        return "造型做低一级，只有一个层次的吊顶，一般离顶120-150mm";
    }
}
