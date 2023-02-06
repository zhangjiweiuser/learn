package learn.chapter2023.chapter02.chapter0203.gongchangmoshi;

import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.ICommodity;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.impl.CardCommodityService;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.impl.CouponCommodityService;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.impl.GoodsCommodityService;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 16:59
 */
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) {
            return null;
        }
        if (1 == commodityType) {
            return new CouponCommodityService();
        }
        if (2 == commodityType) {
            return new GoodsCommodityService();
        }
        if (3 == commodityType) {
            return new CardCommodityService();
        }

        throw new RuntimeException("不存在的商品服务类型");
    }
}
