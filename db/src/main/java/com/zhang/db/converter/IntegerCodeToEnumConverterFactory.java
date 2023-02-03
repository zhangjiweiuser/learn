package com.zhang.db.converter;

import com.google.common.collect.Maps;
import com.zhang.db.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.Map;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/11 14:42
 */
public class IntegerCodeToEnumConverterFactory implements ConverterFactory<Integer, BaseEnum> {

    private static final Map<Class, Converter> CONVERTERS = Maps.newHashMap();


    @Override
    public <T extends BaseEnum> Converter<Integer, T> getConverter(Class<T> aClass) {
        Converter<Integer, T> converter = CONVERTERS.get(aClass);
        if (converter == null) {
            converter = new IntegerToEnumConverter<>(aClass);
            CONVERTERS.put(aClass, converter);
        }
        return converter;

    }
}
