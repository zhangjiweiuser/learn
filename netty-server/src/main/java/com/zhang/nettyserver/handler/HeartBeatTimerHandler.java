package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.dto.HeartBeatRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 17:06
 */
public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {

    private static final int HEARTBEAT_INTERVAL = 5;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        scheduleSendHeartBeat(ctx);
//        super.channelActive(ctx);
    }
    private void scheduleSendHeartBeat(ChannelHandlerContext ctx){
        ctx.executor().schedule(()->{
            if(ctx.channel().isActive()){
                System.out.println("我开始往服务端发送心跳了");
                ctx.channel().writeAndFlush(new HeartBeatRequestPacket());
                scheduleSendHeartBeat(ctx);
            }
        },HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
    }
}
