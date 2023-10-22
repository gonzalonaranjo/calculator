package com.gonzalo.calculator.api;

import com.gonzalo.calculator.model.OperationType;
import com.gonzalo.calculator.service.CalculatorService;
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

    @GetMapping(value = "{operationType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> calculate(@PathVariable OperationType operationType,
                                            @Valid @RequestParam @NotNull BigDecimal firstOperand,
                                            @Valid @RequestParam @NotNull BigDecimal secondOperand) {

        return ResponseEntity.ok(service.calculate(operationType, firstOperand, secondOperand));
    }
}
