package com.gonzalo.calculator.api.model;

import com.gonzalo.calculator.api.model.response.OperationDto;

import java.util.Set;

public class OperationsDto {

    public static String ADD = "ADD";
    public static String SUBTRACT = "SUBTRACT";
    
    public static Set<OperationDto> getOperationDtoSet() {
        return Set.of(
          OperationDto.builder()
                  .operation(ADD)
                  .build(),
                OperationDto.builder()
                        .operation(SUBTRACT)
                        .build()      
        );
    }
}
