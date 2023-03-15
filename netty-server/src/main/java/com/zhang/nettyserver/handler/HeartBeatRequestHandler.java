package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.HeartBeatRequestPacket;
import com.zhang.nettyserver.dto.HeartBeatResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 17:15
 */
@ChannelHandler.Sharable
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

    public static final HeartBeatRequestHandler INSTANCE = new HeartBeatRequestHandler();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatRequestPacket heartBeatRequestPacket) throws Exception {
        System.out.println("我收到客户端心跳了");
        ctx.channel().writeAndFlush(new HeartBeatResponsePacket());
    }
}
