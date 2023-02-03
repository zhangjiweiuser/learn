package com.zhang.groovy.dao;

import java.math.BigDecimal;

public interface DiscountDao {

    BigDecimal getDiscount(Integer skuId);
}
