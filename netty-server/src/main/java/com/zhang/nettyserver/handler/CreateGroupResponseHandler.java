package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.CreateGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:42
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket createGroupResponsePacket) throws Exception {
        System.out.println("开始处理：CreateGroupResponseHandler channelRead0");
        System.out.println("群创建成功，id：[" + createGroupResponsePacket.getGroupId() + "],群里面有:" + createGroupResponsePacket.getUsernameList());
    }
}
