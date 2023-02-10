package com.zhang.nettyserver.dto;

public interface Serializer {
    /**
     * JSON 序列化
     */
    byte JSON_SERIALIZER = 1;

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * Java 对象转换成二进制数据
     */
    byte[] serialize(Object object);

    /**
     * 二进制数据转换成Java对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
