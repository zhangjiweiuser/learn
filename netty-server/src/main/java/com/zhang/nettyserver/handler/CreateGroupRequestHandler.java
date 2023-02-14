package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.CreateGroupRequestPacket;
import com.zhang.nettyserver.dto.CreateGroupResponsePacket;
import com.zhang.nettyserver.util.IDUtil;
import com.zhang.nettyserver.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:42
 */
@ChannelHandler.Sharable
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    public static final CreateGroupRequestHandler INSTANCE = new CreateGroupRequestHandler();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) throws Exception {
        System.out.println("开始处理：CreateGroupRequestHandler channelRead0");
        List<String> userIdList = createGroupRequestPacket.getUserIdList();

        List<String> usernameList = new ArrayList<>();
        // 创建一个channel分组
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
        // 筛选出待加入群聊的用户的channel和username
        for (String userId : userIdList) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                usernameList.add(SessionUtil.getSession(channel).getUsername());
            }
        }
        // 创建群聊结果的响应
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(IDUtil.randomUserId());
        createGroupResponsePacket.setUsernameList(usernameList);
        SessionUtil.bindChannelGroup(createGroupResponsePacket.getGroupId(), channelGroup);
        // 给每个客户端都发送拉群通知
        channelGroup.writeAndFlush(createGroupResponsePacket);
        System.out.println("群创建成功，id：[" + createGroupResponsePacket.getGroupId() + "],群里面有:" + createGroupResponsePacket.getUsernameList());
    }
}
