package learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.impl;

import com.alibaba.fastjson2.JSON;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.card.IQiYiCardService;
import learn.chapter2023.chapter02.chapter0203.gongchangmoshi.store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 16:44
 */
@Slf4j
public class CardCommodityService implements ICommodity {

    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodity, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile,bizId);
        log.info("请求参数[爱奇艺兑换卡]->uId:{},commodity:{},bizId:{},extMap:{}",uId,commodity,bizId, JSON.toJSONString(extMap));
        log.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
