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
                System.out.println("????????????");
                Channel channel = ((ChannelFuture) future).channel();
                // ???????????????????????????????????????
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.out.println("???????????????????????????????????????");
            } else {
                // ???????????????
                int order = MAX_RETRY - retry + 1;
                // ?????????????????????
                int delay = 1 << order;
                System.out.println(new Date() + ":??????????????????" + order + "?????????......");
                final int num = retry - 1;
                // bootstrap.config().group() ?????????????????????????????????workerGroup
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
                System.out.println("????????????channel:" + channel.id().toString() + ":" + channel.toString());
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.exec(scanner, channel);

                } else {
                    System.out.println("?????????????????????????????????");
                    consoleCommandManager.exec(scanner, channel);
                }
            }
        }).start();
    }


}
