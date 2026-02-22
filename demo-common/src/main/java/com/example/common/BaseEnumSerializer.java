package com.example.common;

import cn.hutool.core.text.CharSequenceUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BaseEnumSerializer extends JsonSerializer<Enum> {

    @Override
    public void serialize(Enum value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value instanceof BaseEnum) {
            BaseEnum v = (BaseEnum) value;
            jsonGenerator.writeObject(v.getValue());
            String currentName = jsonGenerator.getOutputContext().getCurrentName();
            if (CharSequenceUtil.isBlank(currentName)) {
                currentName = jsonGenerator.getOutputContext().getParent().getCurrentName();
            }
            jsonGenerator.writeObjectField(currentName + "Desc", v.getDesc());
        } else {
            jsonGenerator.writeObject(value.toString());
        }
    }
}
