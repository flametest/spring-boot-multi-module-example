package com.example.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VResponse<T> {
    public final Integer code;
    public final String desc;
    public final T data;

    public VResponse(T data) {
        this.code = 0;
        this.desc = "success";
        this.data = data;
    }

    public static <T> VResponse<T> success(T data) {
        return new VResponse<>(data);
    }
}
