package com.zhang.nettyserver.util;

import java.util.UUID;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:57
 */
public class IDUtil {
    public static String randomUserId() {
        return UUID.randomUUID().toString().substring(0, 5);
    }
}
