package com.zhang.learn.netty.chapter0929;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/29 10:17
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        // 1. 创建bossGroup，workGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            // 2. 创建服务端启动程序
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024) // 设置线程队列链接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) // 设置好保持活动链接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // 创建一个通道匿名对象
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            System.out.println("服务器已准备好");
            // 绑定一个端口并且同步，生成一个ChannelFuture对象
            ChannelFuture future = bootstrap.bind(6668).sync();
            // 对关闭通道进行监听
            future.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
