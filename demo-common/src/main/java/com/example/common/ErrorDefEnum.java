package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum ErrorDefEnum implements Serializable {
    INVALID_PARAM_EXCEPTION(400, "Invalid Parameter Exception"),

    NOT_FOUND_EXCEPTION(404, "Item Not Found"),

    COMMON_EXCEPTION(500, "Internal Server Error")
    ;

    private Integer code;
    private String desc;

    public ErrorDefEnum desc(String desc) {
        this.desc = desc;
        return this;
    }
}
