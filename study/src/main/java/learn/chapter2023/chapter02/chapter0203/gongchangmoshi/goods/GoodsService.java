package learn.chapter2023.chapter02.chapter0203.gongchangmoshi.goods;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 15:07
 */
@Slf4j
public class GoodsService {
    public Boolean deliverGoods(DeliverReq req) {
        log.info("模拟发放实物商品一个:{}", JSON.toJSONString(req));
        return true;
    }
}
