package com.gonzalo.calculator.factory;

import com.gonzalo.calculator.model.OperationType;

import java.math.BigDecimal;

public interface Operation {

    BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand);
    OperationType getType();
}
