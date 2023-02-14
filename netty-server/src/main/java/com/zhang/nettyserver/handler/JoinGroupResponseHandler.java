package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 14:23
 */
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupResponsePacket joinGroupResponsePacket) throws Exception {
        if (joinGroupResponsePacket.getSuccess()) {
            System.out.println("加入群[" + joinGroupResponsePacket.getGroupId() + "]成功！");
        } else {
            System.out.println("加入群[" + joinGroupResponsePacket.getGroupId() + "]失败，原因为:" + joinGroupResponsePacket.getReason());
        }
    }
}
