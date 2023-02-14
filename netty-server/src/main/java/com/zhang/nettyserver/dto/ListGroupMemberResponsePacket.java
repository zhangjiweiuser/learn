package com.zhang.nettyserver.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-14 10:30
 */
@Data
public class ListGroupMemberResponsePacket extends Packet{

    private String groupId;
    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBER_RESPONSE;
    }
}
