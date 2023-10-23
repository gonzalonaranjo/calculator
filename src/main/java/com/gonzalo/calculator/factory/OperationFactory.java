package com.gonzalo.calculator.factory;

import com.gonzalo.calculator.model.OperationType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@Component
public class OperationFactory {

    private final Map<OperationType, Operation> operationMap = new EnumMap<>(OperationType.class);

    public OperationFactory(Set<Operation> operations) {
        for(Operation operation : operations) {
            operationMap.put(operation.getType(), operation);
        }
    }

    public Operation getOperation(OperationType type) {
        return operationMap.get(type);
    }
}
