package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe;

import java.math.BigDecimal;

/**
 * 装修物料
 */
public interface Matter {
    /**
     * 场景：地板，地砖，涂料，吊顶
     */
    String scene();

    /**
     * 品牌
     */
    String brand();

    /**
     * 型号
     */
    String model();

    /**
     * 价格
     */
    BigDecimal price();

    /**
     * 描述
     */
    String desc();
}
