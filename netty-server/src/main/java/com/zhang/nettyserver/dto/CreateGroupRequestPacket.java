package com.zhang.nettyserver.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:30
 */
@Data
public class CreateGroupRequestPacket extends Packet{

    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}
