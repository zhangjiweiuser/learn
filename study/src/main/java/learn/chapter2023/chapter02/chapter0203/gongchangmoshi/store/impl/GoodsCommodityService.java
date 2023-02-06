package learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.impl;

import com.alibaba.fastjson2.JSON;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.goods.DeliverReq;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.goods.GoodsService;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 16:56
 */
@Slf4j
public class GoodsCommodityService implements ICommodity {
    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodity, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodity);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        log.info("请求参数[优惠券] => uId：{} commodity：{} bizId：{} extMap：{}", uId, commodity, bizId, JSON.toJSON(extMap));
        log.info("测试结果[优惠券]：{}", isSuccess);

        if (!isSuccess) {
            throw new RuntimeException("实物商品发放失败");
        }
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}
