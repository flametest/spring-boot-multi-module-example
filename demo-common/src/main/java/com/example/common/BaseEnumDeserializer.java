package com.example.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BaseEnumDeserializer extends JsonDeserializer<BaseEnum> {

    @Override
    public BaseEnum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        if (value == null || value.isEmpty()) {
            return null;
        }

        Class<?> targetClass = ctxt.getContextualType().getRawClass();

        return BaseEnum.valueOf((Class<? extends BaseEnum>) targetClass, value);
    }
}
