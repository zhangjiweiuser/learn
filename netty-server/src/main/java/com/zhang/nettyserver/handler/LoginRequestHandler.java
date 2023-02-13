package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.LoginRequestPacket;
import com.zhang.nettyserver.dto.LoginResponsePacket;
import com.zhang.nettyserver.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 14:36
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        // 登录逻辑
        LoginResponsePacket responsePacket = login(ctx,loginRequestPacket);
        ctx.channel().writeAndFlush(responsePacket);
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
