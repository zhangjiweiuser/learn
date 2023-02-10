package com.zhang.nettyserver.dto;

import com.alibaba.fastjson2.JSON;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-02-10 16:54
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
