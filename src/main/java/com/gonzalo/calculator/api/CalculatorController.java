package com.gonzalo.calculator.api;

import com.gonzalo.calculator.model.ErrorDto;
import com.gonzalo.calculator.model.OperationType;
import com.gonzalo.calculator.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calculator")
@Validated
public class CalculatorController {

    private final CalculatorService service;

    @Operation(
            summary = "calculate",
            tags = {"calculator-service"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorDto.class)
                    )
            )
    })
    @GetMapping(value = "{operationType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> calculate(@PathVariable OperationType operationType,
                                            @Valid @RequestParam @NotNull BigDecimal firstOperand,
                                            @Valid @RequestParam @NotNull BigDecimal secondOperand) {

        return ResponseEntity.ok(service.calculate(operationType, firstOperand, secondOperand));
    }
}
