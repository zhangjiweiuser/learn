package com.zhang.learn.chapter2021.chapter03.chapter0322;

import lombok.Data;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 17:57
 */
@Data
public class PayFingerprintMessage extends PayBaseMessage {
    private String fingerprintTradeId;
}
