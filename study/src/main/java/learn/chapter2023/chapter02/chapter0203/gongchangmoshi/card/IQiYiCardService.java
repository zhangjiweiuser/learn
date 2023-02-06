package learn.chapter2023.chapter02.chapter0203.gongchangmoshi.card;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-03 11:03
 */
@Slf4j
public class IQiYiCardService {
    public void grantToken(String bindMobileNumber,String cardId){
        log.info("模拟发放爱奇艺会员卡一张:{},{}",bindMobileNumber,cardId);
    }
}
