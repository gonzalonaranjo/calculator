package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.OperationDto;
import com.gonzalo.calculator.model.OperationType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService {
    @Override
    public Set<OperationDto> getOperations() {
        return Arrays.stream(OperationType.values())
                .map(this::mapToOperationDto)
                .collect(Collectors.toUnmodifiableSet());
    }

    private OperationDto mapToOperationDto(OperationType operationType) {
        return OperationDto.builder()
                .operation(operationType.name())
                .build();
    }
}
