package com.zhang.groovy.util;

import com.zhang.groovy.dao.DiscountDao;
import com.zhang.groovy.vo.OrderVO;
import com.zhang.groovy.vo.SkuVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/13 15:04
 */
public class OrderCalPriceUtil {
    @Autowired
    private DiscountDao discountDao;

    public void calculatePrice(OrderVO order) {
        BigDecimal amount = BigDecimal.ZERO;
        for (SkuVO sku : order.getSkus()) {
            Integer skuId = sku.getSkuId();
            BigDecimal skuPrice = sku.getSkuPrice();
            BigDecimal discount = discountDao.getDiscount(skuId);
            BigDecimal price = skuPrice.multiply(discount);
            amount = amount.add(price);
        }
        order.setAmount(amount.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    }
}
