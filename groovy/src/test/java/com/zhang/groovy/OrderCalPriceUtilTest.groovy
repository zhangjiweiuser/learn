package com.zhang.groovy

import com.zhang.groovy.dao.DiscountDao
import com.zhang.groovy.util.OrderCalPriceUtil
import com.zhang.groovy.vo.OrderVO
import com.zhang.groovy.vo.SkuVO
import spock.lang.Specification
import spock.lang.Unroll

class OrderCalPriceUtilTest extends Specification {

    def dao = Mock(DiscountDao)
    def tester = new OrderCalPriceUtil(discountDao: dao)

    @Unroll
    def "测试优惠价格"() {
        given: ""
        def sku1 = new SkuVO(skuId: 1, skuPrice: 10)
        def sku2 = new SkuVO(skuId: 2, skuPrice: 11)

        def order = new OrderVO(skus: [sku1, sku2])
        2 * dao.getDiscount(_) >> 0.95 >> 0.8
        when: "计算优惠后的金额"
        tester.calculatePrice(order)
        then: "验证计算结果是否符合预期"
        order.amount == 18.3
    }
}
