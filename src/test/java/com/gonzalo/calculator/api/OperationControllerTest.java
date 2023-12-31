package com.gonzalo.calculator.api;

import com.gonzalo.calculator.api.model.response.OperationDto;
import com.gonzalo.calculator.service.OperationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static com.gonzalo.calculator.api.model.OperationsDto.getOperationDtoSet;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperationControllerTest {

    @InjectMocks
    private OperationController controller;

    @Mock
    private OperationService service;

    @Test
    void getOperationsReturnsAllOperationList() {
        Set<OperationDto> expectedResult = getOperationDtoSet();

        when(service.getOperations()).thenReturn(expectedResult);

        ResponseEntity<Set<OperationDto>> result = controller.getOperations();

        assertThat(result)
                .extracting(ResponseEntity::getStatusCode, ResponseEntity::getBody)
                .containsExactly(HttpStatus.OK, expectedResult);
    }
}
