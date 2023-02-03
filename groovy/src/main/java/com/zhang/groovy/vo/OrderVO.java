package com.zhang.groovy.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/13 15:03
 */
@Data
public class OrderVO {

    private List<SkuVO> skus;
    private BigDecimal amount;
}
