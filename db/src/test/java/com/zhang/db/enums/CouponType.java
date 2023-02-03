package com.zhang.db.enums;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/9/28 17:20
 */
public enum CouponType {
    MJ(1, "满减"),

    ZJ(2, "直减"),

    ZK(3, "折扣"),

    MZK(4, "满金额折扣");

    private int type;
    private String name;

    CouponType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
