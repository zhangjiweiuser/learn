package com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi;


import com.alibaba.fastjson2.JSON;
import com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi.card.IQiYiCardService;
import com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi.coupon.CouponResult;
import com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi.coupon.CouponService;
import com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi.goods.DeliverReq;
import com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 9:33
 */
@Slf4j
public class PrizeController {

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            log.info("奖品发放开始{},req:{}", req.getUId(), reqJson);
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber,req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
        } catch (Exception e) {
            log.error("奖品发放失败:{},req:{}", req.getUId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }
        return awardRes;
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}
