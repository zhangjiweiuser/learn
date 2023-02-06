package learn.chapter2023.chapter02.chapter0203.gongchangmoshi;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 16:31
 */
@Slf4j
public class ApiTest {
    public static void main(String[] args) {
        PrizeController prizeController = new PrizeController();
        log.info("模拟发送优惠券测试");
        // 模拟发放优惠券测试
        AwardReq req01 = new AwardReq();
        req01.setUId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("G0011010121524545401245");
        req01.setBizId("48784548787545");
        AwardRes awardRes01 = prizeController.awardToUser(req01);
        log.info("请求参数:{}", JSON.toJSONString(req01));
        log.info("测试结果:{}", JSON.toJSONString(awardRes01));
        log.info("模拟发放实物商品");
        // 模拟发放实物商品
        AwardReq req02 = new AwardReq();
        req02.setUId("1001");
        req02.setAwardType(2);
        req02.setAwardNumber("78454787548");
        req02.setBizId("151215454518546844");
        req02.setExtMap(new HashMap<String,String>(){{
            put("consigneeUserName", "张三");
            put("consigneeUserPhone", "15210292123");
            put("consigneeUserAddress", "北京市***小区");
        }});
        AwardRes awardRes02 = prizeController.awardToUser(req02);
        log.info("请求参数:{}", JSON.toJSONString(req02));
        log.info("测试结果:{}", JSON.toJSONString(awardRes02));
        log.info("模拟第三方兑换卡（爱奇艺）");
        AwardReq req03 = new AwardReq();
        req03.setUId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber("SDSWER478751SDFEWR478");
        AwardRes awardRes03 = prizeController.awardToUser(req03);
        log.info("请求参数:{}", JSON.toJSONString(req03));
        log.info("测试结果:{}", JSON.toJSONString(awardRes03));
    }
}
