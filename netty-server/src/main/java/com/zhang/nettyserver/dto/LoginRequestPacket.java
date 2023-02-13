package com.zhang.nettyserver.dto;

import lombok.Data;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-10 16:36
 */
@Data
public class LoginRequestPacket extends Packet{
    private String userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
