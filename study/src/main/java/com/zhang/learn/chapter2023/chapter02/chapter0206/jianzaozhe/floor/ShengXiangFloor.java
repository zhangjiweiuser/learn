package com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.floor;

import com.zhang.learn.chapter2023.chapter02.chapter0206.jianzaozhe.Matter;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-06 17:00
 */
public class ShengXiangFloor implements Matter {
    public String scene() {
        return "地板";
    }

    public String brand() {
        return "圣象";
    }

    public String model() {
        return "一级";
    }

    public BigDecimal price() {
        return new BigDecimal(318);
    }

    public String desc() {
        return "圣象地板是中国地板行业著名品牌。圣象地板拥有中国驰名商标、中国名牌、国家免检、中国环境标志认证等多项荣誉。";
    }

}
