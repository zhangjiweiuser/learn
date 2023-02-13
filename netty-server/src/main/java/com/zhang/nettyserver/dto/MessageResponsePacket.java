package com.zhang.nettyserver.dto;

import lombok.Data;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-13 10:41
 */
@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
