package com.zhang.nettyserver.attr;

import com.zhang.nettyserver.dto.Session;
import io.netty.util.AttributeKey;

public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    AttributeKey<Session> SESSION = AttributeKey.valueOf("session");
}
