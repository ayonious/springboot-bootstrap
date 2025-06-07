# Spring boot bootstrapper Project

[![Build and Test](https://github.com/ayonious/springboot-bootstrap/actions/workflows/build.yml/badge.svg)](https://github.com/ayonious/springboot-bootstrap/actions/workflows/build.yml)
[![codecov](https://codecov.io/gh/ayonious/springboot-bootstrap/branch/master/graph/badge.svg)](https://codecov.io/gh/ayonious/springboot-bootstrap)
[![Test Coverage](https://img.shields.io/badge/coverage-80%25-brightgreen.svg)](https://github.com/ayonious/springboot-bootstrap/actions/workflows/build.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Clone this project to create your running springboot Application. 
Things that comes this with:

1. Sample Rest Endpoints
2. Unit Tests and Integration tests with 80%+ code coverage
3. All updated versions of Dependencies
4. Lombok Samples
5. Use of @Value and application.yaml file reading

## Test Coverage

The project maintains a high level of test coverage with:
- Unit tests for individual components
- Integration tests for end-to-end functionality
- Automated coverage reporting via JaCoCo and Codecov

## Build Status

The project uses GitHub Actions for continuous integration, running all tests and generating coverage reports on every push and pull request.

## Build and run from jar
```
mvn clean package
java -jar learn-spring/target/learn-spring.jar
```

## Run through maven command
```
mvn clean install
mvn spring-boot:run
```

## Test with curl command

```
curl -X POST -H "Content-Type: application/json" -d '{"isBody":"false","id1":"xyz","someStupidId":"123321"}' 'http://localhost:3194/v1/ayon/controller/multiply/12/update'
```

output:
```
updatedDatase with12BodyDto(isBody=false, id1=xyz, someStupidId=123321)somethinginRunningMode
```

## Other learning stuffs:

You have a collection of @beans that are initialized by @Autowired, values that are assigned to all the variables with @Autowired are initialized by those created @beans. To have @Value, @Beans to be seens by spring you need at least @Configutiaon/@SpringbootAppliccation/@RestController/.. on top of it
