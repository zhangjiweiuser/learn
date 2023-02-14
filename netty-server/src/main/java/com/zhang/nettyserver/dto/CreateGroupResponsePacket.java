package com.zhang.nettyserver.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:30
 */
@Data
public class CreateGroupResponsePacket extends Packet{
    private Boolean success;
    private String groupId;
    private List<String> usernameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
