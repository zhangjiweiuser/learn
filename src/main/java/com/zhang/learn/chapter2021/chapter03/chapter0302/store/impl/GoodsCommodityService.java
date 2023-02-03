package com.zhang.learn.chapter2021.chapter03.chapter0302.store.impl;

import com.alibaba.fastjson2.JSON;
import com.zhang.learn.chapter2021.chapter03.chapter0302.goods.DeliverReq;
import com.zhang.learn.chapter2021.chapter03.chapter0302.goods.GoodsService;
import com.zhang.learn.chapter2021.chapter03.chapter0302.store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/2 17:37
 */
@Slf4j
public class GoodsCommodityService implements ICommodity {

    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
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
