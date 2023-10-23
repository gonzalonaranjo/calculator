package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.OperationDto;

import java.util.Set;

public interface OperationService {

    Set<OperationDto> getOperations();
}
