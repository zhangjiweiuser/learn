package com.zhang.learn.chapter2023.chapter02.chapter0203.gongchangmoshi;

import lombok.Data;

import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 9:33
 */
@Data
public class AwardReq {
    /**
     * 用户唯一id
     */
    private String uId;
    /**
     * 奖品类型，1：优惠卷，2：实物商品，3：第三方兑换卡（爱奇艺）
     */
    private Integer awardType;
    /**
     * 奖品编号，sku，couponNumber,cardId
     */
    private String awardNumber;
    /**
     * 业务id，防重复
     */
    private String bizId;
    /**
     * 扩展信息
     */
    private Map<String, String> extMap;
}
