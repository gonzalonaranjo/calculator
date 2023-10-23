# calculator microservice

This microservice handles requests for performing arithmetic calculations through a RESTful API.

## Calculate

Perform a specific arithmetic operation with two operands and return the result.

- **Route:** `/api/v1/calculator`
- **Method:** GET
- 
### Path Variable
- `operationType` (string): The type of operation to perform ("ADD" for addition, "SUBTRACT" for subtraction).
#### Request Parameters
- `firstOperand` (number): The first operand.
- `secondOperand` (number): The second operand.

## Operations
Retrieve all the operations supported by the calculator microservice

- **Route:** `/api/v1/operations`
- **Method:** GET

# Technology stack used

stack used: 

- Spring Boot 3.1.5
- Java 17

# Dependencies

- Lombok
- Swagger
- Tracer

to include tracer dependency, execute the command below:
mvn install:install-file -Dfile=<rute to tracer jar>tracer-1.0.0.jar -DgroupId=com.tracer -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true

# Project structure
    |- api: This directory contains the related files which are used for the communication with te system
    |- client: contains the communication with external services like tracer
    |- factory: This directory contains the operation component logic
    |- model: Files related to the domain definition
    |- service: Files related to the service layer, resposible for the business logic

# Maven instructions

Clean the application:

    mvn clean

Compile the application: 

    mvn compile

Running the test: 

    mvn test

Creating the jar:

	mvn clean package

Run the application
    
    mvn spring-boot:run

To execute the application you must include tracer dependency, after that execute the following commands: 
    
    mvn clean package

    mvn spring-boot:run

The application will run in 8080 port, if it is used you can change it in: 
- application.properties files, property: server.port

## Petition examples
- calculate: 
  - ADD:  http://localhost:8080/api/v1/calculator/ADD?firstOperand=1&secondOperand=3
        curl -X 'GET' \
        'http://localhost:8080/api/v1/calculator/ADD?firstOperand=1&secondOperand=3' \
        -H 'accept: application/json'
  - SUBTRACT: http://localhost:8080/api/v1/calculator/SUBTRACT?firstOperand=1&secondOperand=3
        curl -X 'GET' \
        'http://localhost:8080/api/v1/calculator/SUBTRACT?firstOperand=1&secondOperand=3' \
        -H 'accept: application/json'

## Swagger
The server must be running to see it
- [Dev API](http://localhost:8080/swagger-ui/index.html#/calculator-service/calculate)