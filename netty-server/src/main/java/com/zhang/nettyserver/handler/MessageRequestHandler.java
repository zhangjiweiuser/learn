package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.MessageRequestPacket;
import com.zhang.nettyserver.dto.MessageResponsePacket;
import com.zhang.nettyserver.dto.Session;
import com.zhang.nettyserver.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 14:38
 */
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        System.out.println("开始处理：MessageRequestHandler");
        // 1. 活得消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());
        // 处理消息
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setFromUserId(session.getUserId());
        responsePacket.setFromUserName(session.getUsername());
        responsePacket.setMessage(messageRequestPacket.getMessage());

        // 3. 获得消息接收方的channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());
        // 4. 将消息发送给消息接收方
        if(toUserChannel != null && SessionUtil.hasLogin(toUserChannel)){
            toUserChannel.writeAndFlush(responsePacket);
        }
        else{
            System.out.println("【"+messageRequestPacket.getToUserId()+"] 不在线，发送失败！");
        }

//        MessageResponsePacket responsePacket = receiveMessage(messageRequestPacket);
        ctx.channel().writeAndFlush(responsePacket);
    }

    private MessageResponsePacket receiveMessage(MessageRequestPacket messageRequestPacket) {
        System.out.println(new Date() + ":收到客户消息：" + messageRequestPacket.getMessage());
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        return responsePacket;
    }

}
