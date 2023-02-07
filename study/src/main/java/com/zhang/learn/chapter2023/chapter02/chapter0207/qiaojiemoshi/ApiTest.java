package com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi;

import com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.channel.Pay;
import com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.channel.WxPay;
import com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.channel.ZfbPay;
import com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.model.PayFaceMode;
import com.zhang.learn.chapter2023.chapter02.chapter0207.qiaojiemoshi.model.PayFingerPrintMode;

import java.math.BigDecimal;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-07 18:27
 */
public class ApiTest {
    public static void main(String[] args) {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerPrintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));
    }
}
