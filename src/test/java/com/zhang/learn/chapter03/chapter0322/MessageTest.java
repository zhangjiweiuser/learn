package com.zhang.learn.chapter03.chapter0322;

import com.zhang.learn.chapter2021.chapter03.chapter0322.PayBaseMessage;
import com.zhang.learn.chapter2021.chapter03.chapter0322.PayFaceMessage;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 19:09
 */
public class MessageTest {
    public static void main(String[] args) {
        PayFaceMessage message = new PayFaceMessage();
        message.setUId("uid");
        message.setTradeId("tradeId");
        PayBaseMessage baseMessage = null;
        baseMessage = message;
        System.out.println(baseMessage);
    }
}
