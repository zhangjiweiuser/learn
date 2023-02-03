package com.zhang.rocketmq;

import lombok.Data;

import java.util.List;

@Data
public class LocationData {
    private String oid;
    private String orderId;
    private Integer channelId;
    private List<Position> positionList;
    private String type;
}
