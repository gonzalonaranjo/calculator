package com.gonzalo.calculator.factory;

import java.math.BigDecimal;

public interface Operation {

    BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand);
}
