package learn.chapter2021.chapter03.chapter0302.store;

import learn.chapter2021.chapter03.chapter0302.store.impl.CardCommodityService;
import learn.chapter2021.chapter03.chapter0302.store.impl.CouponCommodityService;
import learn.chapter2021.chapter03.chapter0302.store.impl.GoodsCommodityService;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/2 17:39
 */
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
