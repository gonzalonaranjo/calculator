package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.OperationDto;
import com.gonzalo.calculator.factory.OperationFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationFactory factory;

    @Override
    public Set<OperationDto> getOperations() {
        return factory.getOperationTypes().stream()
                .map(this::mapToOperationDto)
                .collect(Collectors.toUnmodifiableSet());
    }

    private OperationDto mapToOperationDto(String operationType) {
        return OperationDto.builder()
                .operation(operationType)
                .build();
    }
}
