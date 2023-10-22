package com.gonzalo.calculator.service;

import com.gonzalo.calculator.client.TracerClient;
import com.gonzalo.calculator.model.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final TracerClient tracerClient;

    @Override
    public BigDecimal calculate(OperationType type, BigDecimal firstOperand, BigDecimal secondOperand) {
        BigDecimal result;

        result = OperationType.ADD.equals(type)
                ? calculateAdd(firstOperand, secondOperand)
                : calculateSubtract(firstOperand, secondOperand);

        tracerClient.trace(result);
        return result;
    }

    private BigDecimal calculateAdd(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.add(secondOperand);
    }

    private BigDecimal calculateSubtract(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.subtract(secondOperand);
    }
}
