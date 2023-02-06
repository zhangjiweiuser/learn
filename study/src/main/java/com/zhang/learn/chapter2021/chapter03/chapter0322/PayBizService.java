package com.zhang.learn.chapter2021.chapter03.chapter0322;

import java.math.BigDecimal;

public interface PayBizService {
    boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType);
}
