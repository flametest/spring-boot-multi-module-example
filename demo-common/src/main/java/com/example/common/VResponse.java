package com.example.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VResponse {
    public final Integer code;
    public final String desc;
    public final Object data;
}
