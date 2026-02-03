package com.example.common;

import java.io.Serializable;

public interface BaseEnum extends Serializable {

    String getValue();

    String getDesc();

    static <E extends BaseEnum> E valueOf(Class<E> enumClass, String value) {
        E[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("this Class object does not represent an enum class.");
        }
        for (E e : enumConstants) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("The value " + value + " is not a valid enum value.");
    }
}
