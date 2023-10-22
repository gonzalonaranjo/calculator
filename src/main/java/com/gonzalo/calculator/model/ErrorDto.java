package com.gonzalo.calculator.model;

import lombok.Builder;

@Builder
public record ErrorDto(String message, String propertyName, String value) {
}
