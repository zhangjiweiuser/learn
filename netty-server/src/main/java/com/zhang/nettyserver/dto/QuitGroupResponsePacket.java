package com.zhang.nettyserver.dto;

import lombok.Data;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:30
 */
@Data
public class QuitGroupResponsePacket extends Packet{

    private String groupId;
    private String reason;
    private Boolean success;

    @Override
    public Byte getCommand() {
        return Command.QUIT_GROUP_RESPONSE;
    }
}
