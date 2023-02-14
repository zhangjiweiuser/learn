package com.zhang.nettyserver.server;

import com.zhang.nettyserver.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {

    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel channel) throws Exception {
//                        channel.pipeline().addLast(new StringDecoder());
//                        channel.pipeline().addLast(new FirstServerHandler());
                        channel.pipeline()
//                                .addLast(new LifeCycleTestHandler())
                                .addLast(new IMIdleStateHandler())
//                                .addLast(new Spliter())
                                .addLast(PacketCodecHandler.INSTANCE)
                                .addLast(HeartBeatRequestHandler.INSTANCE)
                                .addLast(LoginRequestHandler.INSTANCE)
                                // 添加用户认证handler
                                .addLast(AuthHandler.INSTANCE)
                                .addLast(IMHandler.INSTANCE)
//                                .addLast(new PacketEncoder())
                        ;
                    }
                }).bind(8080);
    }
}
