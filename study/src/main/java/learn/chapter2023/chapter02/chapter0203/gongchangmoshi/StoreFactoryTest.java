package learn.chapter2023.chapter02.chapter0203.gongchangmoshi;

import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.ICommodity;

import java.util.HashMap;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 17:02
 */
public class StoreFactoryTest {
    public static void main(String[] args) throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1.优惠券
        ICommodity commodityService1 = storeFactory.getCommodityService(1);
        commodityService1.sendCommodity("1001", "EGM1023938910232121323432", "791098764902132", null);

        // 2. 实物商品
        ICommodity commodityService2 = storeFactory.getCommodityService(2);
        commodityService2.sendCommodity("10001", "9820198721311", "1023000020112221113", new HashMap<String, String>() {{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        }});

        // 3. 第三方兑换卡(爱奇艺)
        ICommodity commodityService3 = storeFactory.getCommodityService(3);
        commodityService3.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);
    }
}
