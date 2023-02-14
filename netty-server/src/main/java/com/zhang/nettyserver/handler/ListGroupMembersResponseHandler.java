package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.ListGroupMemberResponsePacket;
import com.zhang.nettyserver.dto.Session;
import com.zhang.nettyserver.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 14:23
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMemberResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMemberResponsePacket listGroupMemberResponsePacket) throws Exception {
        // 获取群对应的channelGroup
        String groupId = listGroupMemberResponsePacket.getGroupId();
        System.out.println("群[" + groupId + "]中的成员包括:" + listGroupMemberResponsePacket.getSessionList());
    }
}
