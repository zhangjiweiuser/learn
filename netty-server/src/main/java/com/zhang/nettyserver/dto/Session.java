package com.zhang.nettyserver.dto;

import lombok.Data;

@Data
public class Session {

    private String userId;
    private String username;

    public Session(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}
