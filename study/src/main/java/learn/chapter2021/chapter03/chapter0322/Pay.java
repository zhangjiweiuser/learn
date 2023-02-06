package learn.chapter2021.chapter03.chapter0322;

import java.math.BigDecimal;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 14:46
 */
public  interface Pay {
//    protected IPayMode payMode;
//    public Pay(IPayMode payMode){
//        this.payMode = payMode;
//    }

    String transfer(String uId, String tradeId, BigDecimal amount, int payModeType);
}
