package com.zhang.db.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zhang.db.enums.BaseEnum;

import java.io.IOException;
import java.util.Objects;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/12 10:11
 */
public class CustomEnumSerializer extends JsonSerializer<BaseEnum> {
    @Override
    public void serialize(BaseEnum baseEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (Objects.isNull(baseEnum)) {
            jsonGenerator.writeNull();
            return;
        }
        jsonGenerator.writeObject(baseEnum.getCode());
        jsonGenerator.writeFieldName(jsonGenerator.getOutputContext().getCurrentName() + "Desc");
        jsonGenerator.writeString(baseEnum.getName());
    }

    @Override
    public Class<BaseEnum> handledType() {
        return BaseEnum.class;
    }
}
