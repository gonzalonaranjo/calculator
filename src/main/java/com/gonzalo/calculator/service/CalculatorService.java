package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.ResultDto;
import com.gonzalo.calculator.model.OperationType;

import java.math.BigDecimal;

public interface CalculatorService {

    ResultDto calculate(OperationType type, BigDecimal firstOperand, BigDecimal secondOperand);
}
