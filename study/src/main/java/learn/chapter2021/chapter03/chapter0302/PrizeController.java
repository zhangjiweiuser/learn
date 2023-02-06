package learn.chapter2021.chapter03.chapter0302;

import com.alibaba.fastjson2.JSON;
import learn.chapter2021.chapter03.chapter0302.card.IQiYiCardService;
import learn.chapter2021.chapter03.chapter0302.coupon.CouponResult;
import learn.chapter2021.chapter03.chapter0302.coupon.CouponService;
import learn.chapter2021.chapter03.chapter0302.goods.DeliverReq;
import learn.chapter2021.chapter03.chapter0302.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/2 14:30
 */
@Slf4j
public class PrizeController {

    public AwardRes awardToUser(AwardReq req) {
        log.info("奖品发放开始{},req:{}", req.getUId(), JSON.toJSONString(req));
        AwardRes awardRes = null;
        try {
            // 1:优惠券，2：实物商品，3：第三方兑换券
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
                boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            log.info("奖品发放完成{}", req.getUId());
        } catch (Exception e) {
            log.error("奖品发放失败{},req:{}", req.getUId(), JSON.toJSONString(req), e);
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
