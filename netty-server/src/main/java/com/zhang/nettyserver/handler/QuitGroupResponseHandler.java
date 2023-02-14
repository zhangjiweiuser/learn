package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.QuitGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 14:23
 */
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket quitGroupResponsePacket) throws Exception {
        if (quitGroupResponsePacket.getSuccess()) {
            System.out.println("退出群[" + quitGroupResponsePacket.getGroupId() + "]成功！");
        } else {
            System.out.println("退出群[" + quitGroupResponsePacket.getGroupId() + "]失败，原因为:" + quitGroupResponsePacket.getReason());
        }
    }
}
