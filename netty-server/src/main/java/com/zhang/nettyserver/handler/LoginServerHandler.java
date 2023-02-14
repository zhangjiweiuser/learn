package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 9:58
 */
public class LoginServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("开始处理：LoginServerHandler channelRead");
        ByteBuf requestByteBuf = (ByteBuf) msg;
        // 解码
        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);
        // 判断是否是登录请求数据包
        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            // 登录校验
            loginResponsePacket.setVersion(packet.getVersion());
            if (valid(loginRequestPacket)) {
                loginResponsePacket.setSuccess(true);
                System.out.println("登录校验成功");
            } else {
                loginResponsePacket.setSuccess(false);
                loginResponsePacket.setReason("账号密码校验失败");
                System.out.println("登录校验失败");
            }
            ByteBuf buf = PacketCodeC.INSTANCE.encode(ctx.alloc().ioBuffer(), loginResponsePacket);
            ctx.channel().writeAndFlush(buf);
        } else if (packet instanceof MessageRequestPacket) {
            // 处理消息
            MessageRequestPacket requestPacket = (MessageRequestPacket) packet;
            System.out.println(new Date() + ":收到客户消息：" + requestPacket.getMessage());
            MessageResponsePacket responsePacket = new MessageResponsePacket();
            responsePacket.setMessage("服务端回复【" + requestPacket.getMessage() + "】");
            ByteBuf responseBuf = PacketCodeC.INSTANCE.encode(ctx.alloc().ioBuffer(), responsePacket);
            ctx.channel().writeAndFlush(responseBuf);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
