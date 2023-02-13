package com.zhang.nettyserver.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 12:46
 */
public class InBoundHandlerA extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InBoundHandlerA：" + msg);
        super.channelRead(ctx, msg);
    }
}
