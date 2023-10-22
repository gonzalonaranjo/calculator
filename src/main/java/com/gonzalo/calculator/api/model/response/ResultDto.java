package com.gonzalo.calculator.api.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ResultDto(
        @Schema(description = "operation result", example = "11")
        BigDecimal result) {
}
