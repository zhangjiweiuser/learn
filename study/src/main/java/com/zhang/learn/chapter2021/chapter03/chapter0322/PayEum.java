package com.zhang.learn.chapter2021.chapter03.chapter0322;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 15:12
 */

public enum PayEum {
    /**
     * 微信支付
     */
    WX(1, "微信"),
    /**
     * 支付宝支付
     */
    ZFB(2, "支付宝");

    private int code;
    private String desc;

    PayEum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static PayEum getByCode(int code) {
        PayEum[] payEumList = values();
        for (PayEum payEum : payEumList) {
            if (code == payEum.code) {
                return payEum;
            }
        }
        return null;
    }
}
