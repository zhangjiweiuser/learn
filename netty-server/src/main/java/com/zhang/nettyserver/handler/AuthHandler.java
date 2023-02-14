package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
@ChannelHandler.Sharable
public class AuthHandler extends SimpleChannelInboundHandler {
    public static final AuthHandler INSTANCE = new AuthHandler();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        System.out.println("开始处理：AuthHandler channelRead0");
        if (!SessionUtil.hasLogin(ctx.channel())) {
            ctx.channel().close();
        } else {
            ctx.pipeline().remove(this);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("开始处理：AuthHandler handlerRemoved");
        if (SessionUtil.hasLogin(ctx.channel())) {
            System.out.println("当前连接登录验证完毕，无需再次验证，authHandler 被移除");
        }
    }
}
