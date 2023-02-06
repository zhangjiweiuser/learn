package com.zhang.learn.chapter2021.chapter03.chapter0322;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/22 15:22
 */
public enum PayModeEnum {
    /**
     * 面部识别
     */
    FACE(1, "面部识别"),

    /**
     * 指纹支付
     */
    FINGERPRINT(2, "指纹支付"),
    /**
     * 密码支付
     */
    CYPHER(3, "密码支付");

    private int code;
    private String desc;

    PayModeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getName(){
        return "";
    }

    public static PayModeEnum getByCode(int code) {
        PayModeEnum[] payModeEnumList = values();
        for (PayModeEnum payModeEnum : payModeEnumList) {
            if (code == payModeEnum.code) {
                return payModeEnum;
            }
        }
        return null;
    }
}
