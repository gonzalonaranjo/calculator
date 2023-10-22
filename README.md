# calculator microservice

This microservice handles requests for performing arithmetic calculations through a RESTful API.

## Calculate

Perform a specific arithmetic operation with two operands and return the result.

- **Route:** `/api/v1/calculator`
- **Method:** GET
### Path Variable
- `operationType` (string): The type of operation to perform (e.g., "ADD" for addition, "SUBTRACT" for subtraction).
#### Request Parameters
- `firstOperand` (number): The first operand.
- `secondOperand` (number): The second operand.

# Technology stack used

stack used: 

- Spring Boot 3.1.5
- Lombok
- Java 17

# Dependency
We must add Tracer dependency to run the service

mvn install:install-file -Dfile=<rute to tracer jar>tracer-1.0.0.jar -DgroupId=com.tracer -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true

# Maven instructions

Clean the application:

    mvn clean

Compile the application: 

    mvn compile

Running the test: 

    mvn test

Creating the jar:

	mvn clean package