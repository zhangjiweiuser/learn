package learn.chapter2021.chapter03.chapter0302.store.impl;

import com.alibaba.fastjson2.JSON;
import learn.chapter2021.chapter03.chapter0302.card.IQiYiCardService;
import learn.chapter2021.chapter03.chapter0302.store.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/2 17:35
 */
@Slf4j
public class CardCommodityService implements ICommodity {
    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        log.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        log.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
