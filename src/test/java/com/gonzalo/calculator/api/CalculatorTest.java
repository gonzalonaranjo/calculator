package com.gonzalo.calculator.api;

class CalculatorTest {

/*    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void calculateADDOperationTypeReturnsBothElementAdded() {

        BigDecimal expectedResult = BigDecimal.TEN;

        ResponseEntity<BigDecimal> result =
                calculate(OperationType.ADD.name(), "4", "6", BigDecimal.class);

        then(result)
                .extracting(ResponseEntity::getStatusCode, ResponseEntity::getBody)
                .containsExactly(HttpStatus.OK, expectedResult);
    }

    @Test
    void calculateSUBTRACTOperationTypeReturns() {
        BigDecimal expectedResult = BigDecimal.ONE;

        ResponseEntity<BigDecimal> result =
                calculate(OperationType.SUBTRACT.name(), "4", "3", BigDecimal.class);

        then(result)
                .extracting(ResponseEntity::getStatusCode, ResponseEntity::getBody)
                .containsExactly(HttpStatus.OK, expectedResult);
    }

    @Test
    void errorDtoReturnedWhenOperand1IsMissing() {
        ErrorDto expectedError = ErrorDto.builder()
                .propertyName("firstOperand")
                .build();

        ResponseEntity<ErrorDto> response =
                calculate(OperationType.ADD.name(), "a", "3", ErrorDto.class);

        then(response)
                .satisfies(entity -> {
                    assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
                    assertThat(entity.getBody()).isNotNull();
                    assertThat(entity.getBody().propertyName()).isEqualTo(expectedError.propertyName());
                });
    }

    @Test
    void errorDtoReturnedWhenBadOperand() {
        ErrorDto expectedError = ErrorDto.builder()
                .propertyName("operationType")
                .build();
        ResponseEntity<ErrorDto> response =
                calculate("badOperationType", null, "3", ErrorDto.class);

        then(response)
                .satisfies(entity -> {
                    assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
                    assertThat(entity.getBody()).isNotNull();
                    assertThat(entity.getBody().propertyName()).isEqualTo(expectedError.propertyName());
                });
    }

    private <T> ResponseEntity<T> calculate(
            String operationType, String firstOperand, String secondOperand, Class<T> responseType) {

        return restTemplate.getForEntity(
                generateUriBuilder(firstOperand, secondOperand)
                        .buildAndExpand(generateUriVariable(operationType))
                        .toUriString()
                , responseType);
    }

    private Map<String, String> generateUriVariable(String operationType) {
        return  Map.of("operationType", operationType);
    }

    private UriComponentsBuilder generateUriBuilder(String firstOperand, String secondOperand) {
        String url = "/api/v1/calculator/{operationType}";

        return UriComponentsBuilder.fromUriString(url)
                .queryParam("firstOperand", firstOperand)
                .queryParam("secondOperand", secondOperand);
    }

 */
}
