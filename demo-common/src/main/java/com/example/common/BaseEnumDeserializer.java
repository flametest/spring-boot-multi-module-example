package com.example.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import java.io.IOException;

public class BaseEnumDeserializer extends JsonDeserializer<Enum> implements ContextualDeserializer {

    private Class<?> targetClass;

    public BaseEnumDeserializer() {
    }

    public BaseEnumDeserializer(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        return new BaseEnumDeserializer(beanProperty.getType().getRawClass());
    }

    @Override
    public Enum<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (targetClass == null) {
            throw new IOException("Target class not set for BaseEnumDeserializer");
        }

        if (!BaseEnum.class.isAssignableFrom(targetClass)) {
            Class<? extends Enum> enumType = (Class<? extends Enum>) targetClass;
            return Enum.valueOf(enumType, value);
        }

        Class<BaseEnum> baseEnumClass = (Class<BaseEnum>) targetClass;

        return (Enum<? extends BaseEnum>)BaseEnum.valueOf(baseEnumClass, value);
    }
}
