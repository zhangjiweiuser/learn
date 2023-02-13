package com.zhang.nettyserver.util;


import com.zhang.nettyserver.attr.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 10:47
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> attr = channel.attr(Attributes.LOGIN);
        return attr.get() != null;
    }
}
