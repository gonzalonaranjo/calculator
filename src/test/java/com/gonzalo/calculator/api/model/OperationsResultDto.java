package com.gonzalo.calculator.api.model;

import com.gonzalo.calculator.api.model.response.OperationDto;
import com.gonzalo.calculator.model.OperationType;

import java.util.Set;

public class OperationsResultDto {
    
    public static Set<OperationDto> getOperationDtoSet() {
        return Set.of(
          OperationDto.builder()
                  .operation(OperationType.ADD.name())
                  .build(),
                OperationDto.builder()
                        .operation(OperationType.SUBTRACT.name())
                        .build()      
        );
    }
}
