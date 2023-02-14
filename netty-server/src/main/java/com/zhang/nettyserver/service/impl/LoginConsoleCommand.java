package com.zhang.nettyserver.service.impl;

import com.zhang.nettyserver.dto.LoginRequestPacket;
import com.zhang.nettyserver.service.ConsoleCommand;
import io.netty.channel.Channel;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:38
 */
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("输入用户名:");
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        String userName = scanner.nextLine();
        loginRequestPacket.setUsername(userName);
        loginRequestPacket.setPassword("pwd");
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {

        }
    }
}
