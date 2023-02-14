package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.LoginRequestPacket;
import com.zhang.nettyserver.dto.LoginResponsePacket;
import com.zhang.nettyserver.dto.Session;
import com.zhang.nettyserver.util.IDUtil;
import com.zhang.nettyserver.util.LoginUtil;
import com.zhang.nettyserver.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 14:36
 */
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        System.out.println("开始处理：LoginRequestHandler channelRead0");
        System.out.println("开始处理登录逻辑:" + loginRequestPacket.getUsername());
        // 登录逻辑
//        LoginResponsePacket responsePacket = login(ctx, loginRequestPacket);
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        responsePacket.setVersion(loginRequestPacket.getVersion());
        responsePacket.setSuccess(true);
        String userId = IDUtil.randomUserId();
        responsePacket.setUserId(userId);
        responsePacket.setUsername(loginRequestPacket.getUsername());
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


}
