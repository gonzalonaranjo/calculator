package com.gonzalo.calculator.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record ErrorDto(
        @Schema(description = "exception message")
        String message,
        @Schema(description = "property who caused the exception")
        String propertyName,
        @Schema(description = "value of the property")
        String value) {
}
