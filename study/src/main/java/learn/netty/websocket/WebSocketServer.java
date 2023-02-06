package learn.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/29 10:17
 */
public class WebSocketServer {
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
                            ChannelPipeline pipeline = ch.pipeline();
                            // 因为基于http协议，使用http的编码和解码器
                            pipeline.addLast(new HttpServerCodec());
                            // 以块方式写入
                            pipeline.addLast(new ChunkedWriteHandler());
                            // http 数据在传输过程中是分段的，HttpObjectAggregator可以将多个段聚合，这就是为什么当浏览器发送大量数据时就会发出多次http请求
                            pipeline.addLast(new HttpObjectAggregator(8192));
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
