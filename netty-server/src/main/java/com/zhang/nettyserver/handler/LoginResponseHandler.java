package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.LoginResponsePacket;
import com.zhang.nettyserver.dto.Session;
import com.zhang.nettyserver.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 15:09
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        System.out.println("开始处理：LoginResponseHandler channelRead0");
        if (loginResponsePacket.getSuccess()) {
//            LoginUtil.markAsLogin(ctx.channel());
            Session session = new Session(loginResponsePacket.getUserId(), loginResponsePacket.getUsername());
            SessionUtil.bindSession(session, ctx.channel());
            System.out.println(new Date() + ": 客户端登录成功");
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
        }
    }

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println(new Date() + ": 客户端开始登录");
//        // 创建登录对象
//        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
//        loginRequestPacket.setUserId(UUID.randomUUID().toString());
//        loginRequestPacket.setUsername("flash");
//        loginRequestPacket.setPassword("pwd");
//        // 编码
////        ByteBuf buf = PacketCodeC.INSTANCE.encode(ctx.alloc().ioBuffer(), loginRequestPacket);
//        // 写数据
//        ctx.channel().writeAndFlush(loginRequestPacket);
//    }

}
