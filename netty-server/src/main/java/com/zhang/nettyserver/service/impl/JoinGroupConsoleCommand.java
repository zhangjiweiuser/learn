package com.zhang.nettyserver.service.impl;

import com.zhang.nettyserver.dto.JoinGroupRequestPacket;
import com.zhang.nettyserver.service.ConsoleCommand;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:16
 */
public class JoinGroupConsoleCommand implements ConsoleCommand{

    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();
        System.out.println("输入 groupId，加入群聊：");
        String groupId = scanner.next();
        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}