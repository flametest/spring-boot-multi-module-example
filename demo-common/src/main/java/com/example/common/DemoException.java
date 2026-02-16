package com.example.common;

import lombok.Data;

@Data
public class DemoException extends RuntimeException {

    private final ErrorDefEnum errorDefEnum;

    public DemoException(ErrorDefEnum errorDefEnum) {
        this(errorDefEnum, null);
    }

    public DemoException(ErrorDefEnum errorDefEnum, Throwable e) {
        super(errorDefEnum.getDesc(), e);
        this.errorDefEnum = errorDefEnum;
    }
}
