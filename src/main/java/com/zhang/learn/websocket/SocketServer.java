package com.zhang.learn.websocket;

import com.zhang.learn.netty.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/10/7 20:16
 */
public class SocketServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup pGroup = new NioEventLoopGroup();
        EventLoopGroup cGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(pGroup, cGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        // 因为基于http协议，所以使用http的编解码器
                        pipeline.addLast("httpDecoder", new HttpServerCodec());
                        // 是以块方式进行读写，所以需要chunkedWrite处理器
                        pipeline.addLast(new ChunkedWriteHandler());
                        // 1. 说明，http数据在传输过程中的分段的，HttpObjectAggregator可以将多个段聚合起来，
                        // 2. 这就是为什么当浏览器发送大量数据时，就会发出多次http请求的原因
                        pipeline.addLast(new HttpObjectAggregator(8192));
                        // 对于websocket，它的数据是以帧（frame）形式传递，
                        // 可以看到websocketFrame下面有六个字段
                        // 浏览器请求时 ws://localhost:7000/xxx 表示请求的url，比如xxx为hello
                        // WebSocketServerProtocolHandler 核心功能是将http协议升级为ws协议，以及websocket协议
                        pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));
                        // 自定义handler
                        pipeline.addLast(new SocketServerHandler());
                    }
                });

        ChannelFuture cf = bootstrap.bind(8888).sync();
        cf.channel().closeFuture().sync();

        pGroup.shutdownGracefully();
        cGroup.shutdownGracefully();
    }
}
