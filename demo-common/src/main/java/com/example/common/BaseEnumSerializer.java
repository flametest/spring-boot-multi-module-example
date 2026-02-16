package com.example.common;

import cn.hutool.core.text.CharSequenceUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BaseEnumSerializer extends JsonSerializer<BaseEnum> {

    @Override
    public void serialize(BaseEnum baseEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(baseEnum.getValue());
        String currentName = jsonGenerator.getOutputContext().getCurrentName();
        if (CharSequenceUtil.isBlank(currentName)) {
            currentName = jsonGenerator.getOutputContext().getParent().getCurrentName();
        }
        jsonGenerator.writeObjectField(currentName + "Desc", baseEnum.getDesc());
    }
}
