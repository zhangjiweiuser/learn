package com.zhang.learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/8/24 15:13
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server handlerRemoved");
        super.handlerRemoved(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("server userEventTriggered");
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleEvent = (IdleStateEvent) evt;
            if (idleEvent.state() == IdleState.READER_IDLE) {
                Channel channel = ctx.channel();
                if (null != channel) {
                    System.out.println("channel准备关闭");
                    System.out.println("userEventTriggered channelId:" + channel.id().toString());
                    System.out.println("userEventTriggered channelId:" + channel.id().asLongText());
                    System.out.println("userEventTriggered channelId:" + channel.id().asShortText());
                    channel.close();
                } else {
                    System.out.println("channel已关闭");

                }
            } else if (idleEvent.state() == IdleState.WRITER_IDLE) {

            } else if (idleEvent.state() == IdleState.ALL_IDLE) {

            }
        }
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelActive");
//        super.channelActive(ctx);
//        while (true) {
        ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int) (System.currentTimeMillis() / 1000));
        Channel channel = ctx.channel();
        System.out.println("channelActive channelId:" + channel.id().toString());
        System.out.println("channelActive channelId:" + channel.id().asLongText());
        System.out.println("channelActive channelId:" + channel.id().asShortText());
        if (!channel.isActive()) {
            System.out.println("channelActive 已不活跃，关闭channel");
            ctx.close();
            return;
        }

        ctx.channel().writeAndFlush(time);
        TimeUnit.SECONDS.sleep(2);
        System.out.println(time + "server write");
//        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channelRead");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "utf-8");
        System.out.println("server body :" + body);
        String response = "返回给客户端的响应是" + body;
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelReadComplete");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server exceptionCaught");
        System.out.println("name:" + ctx.name());
        Channel channel = ctx.channel();
        if (null != channel) {
            System.out.println("channelId:" + channel.id().toString());
            System.out.println("channelId:" + channel.id().asLongText());
            System.out.println("channelId:" + channel.id().asShortText());
        } else {
            System.out.println("channel is close");
        }

        ctx.close();
    }
}
