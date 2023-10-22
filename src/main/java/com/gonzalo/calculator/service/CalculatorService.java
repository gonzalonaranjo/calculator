package com.gonzalo.calculator.service;

import com.gonzalo.calculator.model.OperationType;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal calculate(OperationType type, BigDecimal firstOperand, BigDecimal secondOperand);
}
