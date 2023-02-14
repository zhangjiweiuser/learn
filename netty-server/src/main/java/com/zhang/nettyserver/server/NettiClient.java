package com.zhang.nettyserver.server;

import com.zhang.nettyserver.decoder.PacketDecoder;
import com.zhang.nettyserver.decoder.Spliter;
import com.zhang.nettyserver.encoder.PacketEncoder;
import com.zhang.nettyserver.handler.*;
import com.zhang.nettyserver.service.impl.ConsoleCommandManager;
import com.zhang.nettyserver.service.impl.LoginConsoleCommand;
import com.zhang.nettyserver.util.SessionUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NettiClient {

    private static final int MAX_RETRY = 5;

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        bootstrap.group(workerGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel channel) throws Exception {
                channel.pipeline()
                        .addLast(new IMIdleStateHandler())
                        .addLast(new HeartBeatTimerHandler())
                        .addLast(new Spliter())
                        .addLast(new PacketDecoder())
                        .addLast(new LoginResponseHandler())
                        .addLast(new MessageResponseHandler())
                        .addLast(new CreateGroupResponseHandler())
                        .addLast(new JoinGroupResponseHandler())
                        .addLast(new QuitGroupResponseHandler())
                        .addLast(new ListGroupMembersResponseHandler())
                        .addLast(new PacketEncoder());
//                                .addLast(new StringEncoder())
//                                .addLast(new FirstClientHandler());
//                                .addLast(new LoginClientHandler());
            }
        });
        connect(bootstrap, "127.0.0.1", 8080, MAX_RETRY);
        /*.channel();
        while (true) {
            channel.writeAndFlush(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": hello world!");
            TimeUnit.SECONDS.sleep(2);
        }*/
    }

    private static void connect(Bootstrap bootstrap, String host, int port, final int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功");
                Channel channel = ((ChannelFuture) future).channel();
                // 连接成功后，启动控制台线程
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.out.println("重试次数已用完，放弃连接！");
            } else {
                // 第几次重连
                int order = MAX_RETRY - retry + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.out.println(new Date() + ":连接失败，第" + order + "次重连......");
                final int num = retry - 1;
                // bootstrap.config().group() 是启动时配置的线程模型workerGroup
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, num), delay, TimeUnit.SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        Scanner scanner = new Scanner(System.in);
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("验证用的channel:" + channel.id().toString() + ":" + channel.toString());
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.exec(scanner, channel);

                } else {
                    System.out.println("验证成功，我走到这里了");
                    consoleCommandManager.exec(scanner, channel);
                }
            }
        }).start();
    }


}
