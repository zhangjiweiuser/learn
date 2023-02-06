package com.zhang.learn.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/29 16:18
 */
public class TestHttpHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        // httpObject 是前后端进行交互的数据格式
        // 只处理httpRequest请求
        if (msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            String uri = httpRequest.uri();
            if ("/favicon.ico".equals(uri)) {
                System.out.println("图片不做处理");
                return;
            }
            System.out.println("msg 类型：" + msg.getClass());
            System.out.println("msg method:" + ((HttpRequest) msg).method());
            System.out.println("msg url:" + ((HttpRequest) msg).uri());
            ByteBuf content = Unpooled.copiedBuffer("当前时间是：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(response);
        }
    }
}
