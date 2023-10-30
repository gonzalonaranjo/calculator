package com.gonzalo.calculator.model;

import lombok.Getter;

@Getter
public class UnsupportedTypeException extends RuntimeException {

    private final String parameter;

    public UnsupportedTypeException (String message, String parameter) {
        super(message);
        this.parameter = parameter;
    }
}
