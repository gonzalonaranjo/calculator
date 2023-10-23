package com.gonzalo.calculator.api;

import com.gonzalo.calculator.api.model.response.OperationDto;
import com.gonzalo.calculator.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/operations")
public class OperationController {

    private final OperationService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<OperationDto>> getOperations() {
        return ResponseEntity.ok(service.getOperations());
    }
}
