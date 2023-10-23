package com.gonzalo.calculator.factory;

import com.gonzalo.calculator.model.OperationType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("addition")
public class Addition implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.add(secondOperand);
    }

    @Override
    public OperationType getType() {
        return OperationType.ADD;
    }
}
