package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.coat;

import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.Matter;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 16:57
 */
public class DuluxCoat implements Matter {
    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "多乐士(Dulux)";
    }

    @Override
    public String model() {
        return "第二代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(719);
    }

    @Override
    public String desc() {
        return "多乐士是阿克苏诺贝尔旗下的著名建筑装饰油漆品牌，产品畅销于全球100个国家，每年全球有5000万户家庭使用多乐士油漆。";
    }
}
