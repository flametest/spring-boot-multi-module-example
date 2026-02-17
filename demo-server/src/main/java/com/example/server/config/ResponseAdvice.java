package com.example.server.config;

import com.example.common.DemoException;
import com.example.common.IgnoreResponseAdvice;
import com.example.common.VResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true; // intercept all request
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.hasMethodAnnotation(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (body instanceof VResponse) {
            return body;
        }
        return VResponse.success(body);
    }

    @ExceptionHandler(DemoException.class)
    public VResponse<?> demoException(DemoException e) {
        log.error("Demo Exception", e);
        return new VResponse<>(e.getErrorDefEnum().getCode(), e.getErrorDefEnum().getDesc(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public VResponse<?> methodArgNotValidException(MethodArgumentNotValidException e) {
        log.error("Validate Exception", e);
        String msg = Optional.ofNullable(e.getBindingResult().getAllErrors())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(ObjectError::getDefaultMessage)
                .distinct()
                .collect(Collectors.joining(", "));
        return new VResponse<>(400, msg, null);
    }


    @ExceptionHandler(Exception.class)
    public VResponse<?> exception(Exception e) {
        log.error("Exception", e);
        return new VResponse<>(500, e.getMessage(), null);
    }
}
