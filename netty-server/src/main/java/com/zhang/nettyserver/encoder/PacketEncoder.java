package com.zhang.nettyserver.encoder;

import com.zhang.nettyserver.dto.Packet;
import com.zhang.nettyserver.dto.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 14:49
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}
