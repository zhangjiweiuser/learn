package com.zhang.nettyserver.decoder;

import com.zhang.nettyserver.dto.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 14:57
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
        out.add(PacketCodeC.INSTANCE.decode(byteBuf));
    }
}
