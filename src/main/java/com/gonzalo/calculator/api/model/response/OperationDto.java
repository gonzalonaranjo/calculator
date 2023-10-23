package com.gonzalo.calculator.api.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record OperationDto(
        @Schema(description = "operation result", example = "ADD")
        String operation) implements Serializable {
}
