package com.gonzalo.calculator.service;

import com.gonzalo.calculator.client.TracerClient;
import com.gonzalo.calculator.factory.OperationFactory;
import com.gonzalo.calculator.model.OperationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final OperationFactory factory;
    private final TracerClient tracerClient;

    @Override
    public BigDecimal calculate(OperationType type, BigDecimal firstOperand, BigDecimal secondOperand) {
        BigDecimal result = factory.getOperation(type).calculate(firstOperand, secondOperand);

        tracerClient.trace(result);
        return result;
    }
}
