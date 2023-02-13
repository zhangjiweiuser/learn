package com.zhang.nettyserver.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 12:46
 */
public class InBoundHandlerB extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InBoundHandlerB：" + msg);
        super.channelRead(ctx, msg);
    }
}
