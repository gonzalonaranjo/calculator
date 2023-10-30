package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.ResultDto;
import com.gonzalo.calculator.client.TracerClient;
import com.gonzalo.calculator.factory.OperationFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final OperationFactory factory;
    private final TracerClient tracerClient;

    @Override
    public ResultDto calculate(String type, BigDecimal firstOperand, BigDecimal secondOperand) {
        BigDecimal result = factory.getOperation(type).calculate(firstOperand, secondOperand);

        tracerClient.trace(result);
        return ResultDto.builder()
                .result(result)
                .build();
    }
}
