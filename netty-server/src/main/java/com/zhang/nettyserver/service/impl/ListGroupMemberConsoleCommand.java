package com.zhang.nettyserver.service.impl;

import com.zhang.nettyserver.dto.ListGroupMemberRequestPacket;
import com.zhang.nettyserver.service.ConsoleCommand;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 15:07
 */
public class ListGroupMemberConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMemberRequestPacket requestPacket = new ListGroupMemberRequestPacket();
        System.out.println("输入 groupId，获取群成员列表:");
        String groupId = scanner.next();
        requestPacket.setGroupId(groupId);
        channel.writeAndFlush(requestPacket);
    }
}
