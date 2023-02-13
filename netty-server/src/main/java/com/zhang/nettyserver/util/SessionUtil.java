package com.zhang.nettyserver.util;

import com.zhang.nettyserver.attr.Attributes;
import com.zhang.nettyserver.dto.Session;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {

    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();
    private static final Map<String, String> fuwu2kehu = new ConcurrentHashMap<>();

    public static void bindSession(Session session,Channel channel){
        System.out.println("bindSession："+channel.toString());
        userIdChannelMap.put(session.getUserId(),channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel){
        if(hasLogin(channel)){
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    public static boolean hasLogin(Channel channel){
        System.out.println("hasLogin："+channel.toString());
        Attribute<Session> attr = channel.attr(Attributes.SESSION);
        System.out.println(attr);
        if(attr.get() != null){
            System.out.println("-----------------");
            System.out.println(attr.get().getUsername());
        }
//        return channel.hasAttr(Attributes.SESSION);
        return attr.get() != null;
    }

    public static Session getSession(Channel channel){
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId){
        return userIdChannelMap.get(userId);
    }
}
