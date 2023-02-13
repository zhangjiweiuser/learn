package com.zhang.nettyserver.handler;

import com.alibaba.fastjson2.util.UUIDUtils;
import com.zhang.nettyserver.dto.LoginRequestPacket;
import com.zhang.nettyserver.dto.LoginResponsePacket;
import com.zhang.nettyserver.dto.Session;
import com.zhang.nettyserver.util.LoginUtil;
import com.zhang.nettyserver.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 14:36
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        System.out.println("开始处理登录逻辑:" + loginRequestPacket.getUsername());
        // 登录逻辑
//        LoginResponsePacket responsePacket = login(ctx, loginRequestPacket);
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        responsePacket.setVersion(loginRequestPacket.getVersion());
        responsePacket.setSuccess(true);
        String userId = randomUserId();
        responsePacket.setUserId(userId);
        System.out.println("登录用的channel"+ctx.channel().id().toString()+":"+ctx.channel().toString());
        SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), ctx.channel());
        ctx.channel().writeAndFlush(responsePacket);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }

    private LoginResponsePacket login(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            LoginUtil.markAsLogin(ctx.channel());
            loginResponsePacket.setSuccess(true);
            System.out.println("登录校验成功");
        } else {
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("账号密码校验失败");
            System.out.println("登录校验失败");
        }
        return loginResponsePacket;
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    private String randomUserId() {
        return UUID.randomUUID().toString().substring(0, 5);
    }
}
