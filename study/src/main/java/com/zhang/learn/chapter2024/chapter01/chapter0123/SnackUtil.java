package com.zhang.learn.chapter2024.chapter01.chapter0123;

import lombok.Data;
import lombok.ToString;
import org.noear.snack.ONode;

public class SnackUtil {
    public static void main(String[] args) {
        User user = new User();
        user.setId(10);
        user.setName("zhang");
        String userJson = ONode.stringify(user);
        System.out.println(userJson);

        String serializeUser = ONode.serialize(user);
        System.out.println("ONode.serialize:" + serializeUser);

        User user1 = ONode.deserialize(serializeUser);
        System.out.println(user1);

        User user2 = ONode.deserialize(userJson,User.class);
        System.out.println(user2);

        ONode oNodeUser = ONode.loadStr(userJson);
        System.out.println(oNodeUser);
//        Object user3 = oNodeUser.get("user").toObject(User.class);
//        System.out.println(user3);
//        ONode oNodeUser2 = ONode.loadObj(serializeUser);
//        System.out.println(oNodeUser2);
    }

    @Data
    @ToString
    public static class User {
        private int id;
        private String name;
    }
}
