package com.zhang.nettyserver.dto;

import io.netty.buffer.ByteBuf;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-10 17:04
 */
public class PacketCodeC {

    public static PacketCodeC INSTANCE = new PacketCodeC();
    public static final int MAGIC_NUMBER = 0x12345678;

    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
//        // 1. 创建ByteBuf 对象
//        ByteBuf byteBuf = allocator.ioBuffer();
        // 2. 序列化Java对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 3. 实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    //    public ByteBuf encode(ByteBufAllocator allocator, Packet packet) {
//        // 1. 创建ByteBuf 对象
//        ByteBuf byteBuf = allocator.ioBuffer();
//        // 2. 序列化Java对象
//        byte[] bytes = Serializer.DEFAULT.serialize(packet);
//        // 3. 实际编码过程
//        byteBuf.writeInt(MAGIC_NUMBER);
//        byteBuf.writeByte(packet.getVersion());
//        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
//        byteBuf.writeByte(packet.getCommand());
//        byteBuf.writeInt(bytes.length);
//        byteBuf.writeBytes(bytes);
//        return byteBuf;
//    }
    public Packet decode(ByteBuf byteBuf) {
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
        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);
        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }
        return null;
    }

    private Class<? extends Packet> getRequestType(byte command) {
        if (Command.LOGIN_REQUEST == command) {
            return LoginRequestPacket.class;
        } else if (Command.LOGIN_RESPONSE == command) {
            return LoginResponsePacket.class;
        } else if (Command.MESSAGE_REQUEST == command) {
            return MessageRequestPacket.class;
        } else if (Command.MESSAGE_RESPONSE == command) {
            return MessageResponsePacket.class;
        } else if (Command.CREATE_GROUP_REQUEST == command) {
            return CreateGroupRequestPacket.class;
        } else if (Command.CREATE_GROUP_RESPONSE == command) {
            return CreateGroupResponsePacket.class;
        } else if (Command.JOIN_GROUP_REQUEST == command) {
            return JoinGroupRequestPacket.class;
        } else if (Command.JOIN_GROUP_RESPONSE == command) {
            return JoinGroupResponsePacket.class;
        } else if (Command.QUIT_GROUP_REQUEST == command) {
            return QuitGroupRequestPacket.class;
        } else if (Command.QUIT_GROUP_RESPONSE == command) {
            return QuitGroupResponsePacket.class;
        } else if (Command.LIST_GROUP_MEMBER_REQUEST == command) {
            return ListGroupMemberRequestPacket.class;
        } else if (Command.LIST_GROUP_MEMBER_RESPONSE == command) {
            return ListGroupMemberResponsePacket.class;
        }else if (Command.HEARTBEAT_REQUEST == command) {
            return HeartBeatRequestPacket.class;
        }else if (Command.HEARTBEAT_RESPONSE == command) {
            return HeartBeatResponsePacket.class;
        }
        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {
        return new JSONSerializer();
    }
}
