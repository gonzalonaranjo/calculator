package com.gonzalo.calculator.factory;

import com.gonzalo.calculator.model.UnsupportedTypeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OperationFactory {

    private final Map<String, Operation> operationMap = new HashMap<>();

    public OperationFactory(Set<Operation> operations) {
        for(Operation operation : operations) {
            String a = operation.getClass().getAnnotation(Qualifier.class).value();
            operationMap.put(a, operation);
        }
    }

    public Operation getOperation(String type) {
        return Optional.ofNullable(operationMap.get(type))
                .orElseThrow(() -> new UnsupportedTypeException("Operation type not found", type));
    }

    public Set<String> getOperationTypes() {
        return operationMap.keySet().stream().collect(Collectors.toUnmodifiableSet());
    }
}
