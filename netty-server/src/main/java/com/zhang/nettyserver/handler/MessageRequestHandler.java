package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.MessageRequestPacket;
import com.zhang.nettyserver.dto.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 14:38
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        // 处理消息
        MessageResponsePacket responsePacket = receiveMessage(messageRequestPacket);
        ctx.channel().writeAndFlush(responsePacket);
    }

    private MessageResponsePacket receiveMessage(MessageRequestPacket messageRequestPacket) {
        System.out.println(new Date() + ":收到客户消息：" + messageRequestPacket.getMessage());
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        return responsePacket;
    }

}
