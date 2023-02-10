package com.zhang.nettyserver.dto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-10 17:04
 */
public class PacketCodeC {
    private static final int MAGIC_NUMBER = 0x12345678;

    public ByteBuf encode(Packet packet){
        // 1. 创建ByteBuf 对象
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        // 2. 序列化Java对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 3. 实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf){
        // 1. 跳过魔数
        byteBuf.skipBytes(4);
        // 2. 跳过版本号
        byteBuf.skipBytes(1);
        // 3. 序列化算法标识
        byte serializeAlgorithm = byteBuf.readByte();
        // 4. 指令
        byte command = byteBuf.readByte();
        // 5. 数据包长度
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
//        getR
        return null;
    }
}
