package com.zhang.nettyserver.service.impl;

import com.zhang.nettyserver.dto.MessageRequestPacket;
import com.zhang.nettyserver.service.ConsoleCommand;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:16
 */
public class SendToUserConsoleCommand implements ConsoleCommand{

    @Override
    public void exec(Scanner scanner, Channel channel) {
        String toUserId = scanner.next();
        String message = scanner.next();
        MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
        messageRequestPacket.setToUserId(toUserId);
        messageRequestPacket.setMessage(message);
        channel.writeAndFlush(messageRequestPacket);
    }
}