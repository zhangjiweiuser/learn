package learn.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/30 16:36
 */
public class HeartServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = "";
            switch (event.state()) {
                case IdleState.READER_IDLE:
                    eventType = "读空闲";
                    break;
                case IdleState.WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case IdleState.ALL_IDLE:
                    eventType = "读写空闲";
                    break;
                default:
            }
            System.out.println(ctx.channel().remoteAddress() + "发生了" + eventType);
            if (event.state() == IdleState.ALL_IDLE) {
                ctx.close();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

    }
}
