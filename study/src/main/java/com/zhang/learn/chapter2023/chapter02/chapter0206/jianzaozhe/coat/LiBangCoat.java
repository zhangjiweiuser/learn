package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.coat;

import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.Matter;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 16:58
 */
public class LiBangCoat implements Matter {
    public String scene() {
        return "涂料";
    }

    public String brand() {
        return "立邦";
    }

    public String model() {
        return "默认级别";
    }

    public BigDecimal price() {
        return new BigDecimal(650);
    }

    public String desc() {
        return "立邦始终以开发绿色产品、注重高科技、高品质为目标，以技术力量不断推进科研和开发，满足消费者需求。";
    }

}
