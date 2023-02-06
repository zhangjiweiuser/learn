package learn.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/29 16:14
 */
public class TestHttpChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("MyHttpServerCodec",new HttpServerCodec())
                .addLast("MyTestHttpHandler",new TestHttpHandler());

    }
}
