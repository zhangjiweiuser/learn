package com.zhang.db.converter;

import com.google.common.collect.Maps;
import com.zhang.db.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/11 14:35
 */
public class StringToEnumConverter<T extends BaseEnum> implements Converter<String, T> {

    private Map<String, T> enumMap = Maps.newHashMap();

    public StringToEnumConverter(Class<T> enumType) {
        T[] enums = enumType.getEnumConstants();
        for (T e : enums) {
            enumMap.put(e.getCode().toString(), e);
        }
    }

    @Override
    public T convert(String source) {
        T t = enumMap.get(source);
        if (null == t) {

            throw new IllegalArgumentException("无法匹配对应的枚举类型");
        }
        return t;
    }
}
