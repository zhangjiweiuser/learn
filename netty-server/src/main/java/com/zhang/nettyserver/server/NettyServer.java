package com.zhang.nettyserver.server;

import com.zhang.nettyserver.decoder.PacketDecoder;
import com.zhang.nettyserver.decoder.Spliter;
import com.zhang.nettyserver.encoder.PacketEncoder;
import com.zhang.nettyserver.handler.AuthHandler;
import com.zhang.nettyserver.handler.LifeCycleTestHandler;
import com.zhang.nettyserver.handler.LoginRequestHandler;
import com.zhang.nettyserver.handler.MessageRequestHandler;
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
//                                .addLast(new Spliter())
                                .addLast(new PacketDecoder())
                                .addLast(new LoginRequestHandler())
                                // 添加用户认证handler
//                                .addLast(new AuthHandler())
                                .addLast(new MessageRequestHandler())
                                .addLast(new PacketEncoder())
                        ;
                    }
                }).bind(8080);
    }
}
