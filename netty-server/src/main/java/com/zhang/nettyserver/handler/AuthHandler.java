package com.zhang.nettyserver.handler;

import com.zhang.nettyserver.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class AuthHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
//        if (!LoginUtil.hasLogin(ctx.channel())) {
//            ctx.channel().close();
//        } else {
//            ctx.pipeline().remove(this);
//        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if (LoginUtil.hasLogin(ctx.channel())) {
            System.out.println("当前连接登录验证完毕，无需再次验证，authHandler 被移除");
        }
    }
}
