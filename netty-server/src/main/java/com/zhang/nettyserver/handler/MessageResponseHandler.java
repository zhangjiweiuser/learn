package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 15:07
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket messageResponsePacket) throws Exception {
        System.out.println("收到服务端影响：" + messageResponsePacket.getMessage());
    }
}
