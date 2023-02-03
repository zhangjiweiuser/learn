package com.zhang.groovy.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/20 10:03
 */
public class PhoneDesensitizedUtil {

    public static String desensitized(String origin) {
        return StringUtils.left(origin, 3) + "****" + StringUtils.right(origin, 4);
    }

    public static void main(String[] args) {
        System.out.println(desensitized("15136986963"));
    }
}
