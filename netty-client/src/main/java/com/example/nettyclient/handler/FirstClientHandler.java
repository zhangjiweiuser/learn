package com.example.nettyclient.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-10 11:03
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * 该方法会在客户端连接建立成功之后被调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + "：客户端写出数据");
        // 1. 获取数据
        ByteBuf byteBuf = getByteBuf(ctx);
        // 2. 写数据
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ":客户端读取到服务端读到数据->" + byteBuf.toString(StandardCharsets.UTF_8));
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        // 1. 获取二进制抽象 ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 2. 准备数据，指定字符串的字符集为UTF-8
        byte[] bytes = "您好，张先生".getBytes(StandardCharsets.UTF_8);
        // 3. 填充数据到ByteBuf
        buffer.writeBytes(bytes);
        return buffer;
    }
}
