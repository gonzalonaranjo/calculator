package com.gonzalo.calculator.factory;

import com.gonzalo.calculator.model.OperationType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class OperationFactory {

    private final Map<OperationType, Operation> operationMap = new EnumMap<>(OperationType.class);

    public OperationFactory(Addition addition, Subtraction subtraction) {
        operationMap.put(OperationType.ADD, addition);
        operationMap.put(OperationType.SUBTRACT, subtraction);
    }

    public Operation getOperation(OperationType type) {
        return operationMap.get(type);
    }
}
