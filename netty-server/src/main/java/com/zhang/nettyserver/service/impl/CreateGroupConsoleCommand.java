package com.zhang.nettyserver.service.impl;

import com.zhang.nettyserver.dto.CreateGroupRequestPacket;
import com.zhang.nettyserver.service.ConsoleCommand;
import io.netty.channel.Channel;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:22
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {
    private static final String USER_ID_SPLITER = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        System.out.println("CreateGroupConsoleCommand channel :" + channel.toString());
        System.out.println("[拉人群聊] 输入userId列表，userId之间英文逗号隔开：");
        String userIds = scanner.next();
        System.out.println("CreateGroupConsoleCommand userIds:" + userIds);
        createGroupRequestPacket.setUserIdList(Arrays.asList(userIds.split(USER_ID_SPLITER)));
        channel.writeAndFlush(createGroupRequestPacket);
    }
}
