# Spring Boot bootstrapper

[![Build](https://github.com/ayonious/springboot-bootstrap/actions/workflows/build.yml/badge.svg)](https://github.com/ayonious/springboot-bootstrap/actions/workflows/build.yml)
[![codecov](https://codecov.io/gh/ayonious/springboot-bootstrap/graph/badge.svg)](https://codecov.io/gh/ayonious/springboot-bootstrap)

A small Spring Boot 4.0.8 sample with a REST endpoint, Lombok DTO, external configuration, Actuator, and unit and integration tests.

## Requirements

- JDK 21 with `JAVA_HOME` pointing to its installation.
- Internet access for the first build. The Maven wrapper downloads the pinned Maven distribution and dependencies; a separate Maven installation is unnecessary.

With Homebrew on macOS, set `JAVA_HOME` before building:

```sh
export JAVA_HOME="$(brew --prefix openjdk@21)/libexec/openjdk.jdk/Contents/Home"
```

On Windows, use `mvnw.cmd` in place of `./mvnw`.

## Build and test

```sh
./mvnw clean verify
```

This compiles the application, runs all tests, builds the executable JAR, and enforces at least 80% line coverage (excluding the DTO package). Open `target/site/jacoco/index.html` to inspect coverage.

CI uses the same command with Java 21 and uploads the JAR, test reports, and Codecov coverage report.

## Run

```sh
java -jar target/sample-springboot.jar
```

Or run directly through Maven:

```sh
./mvnw spring-boot:run
```

The application listens on port 3194. Configuration is in `src/main/resources/application.yml`; tests use `src/test/resources/application.yml`.

## Try the endpoint

```sh
curl -X POST -H 'Content-Type: application/json' \
  -d '{"isBody":false,"id1":"xyz","someStupidId":123321}' \
  http://localhost:3194/v1/ayon/controller/multiply/12/update
```

Response:

```text
updatedDatase with12BodyDto(isBody=false, id1=xyz, someStupidId=123321)somethinginRunningMode
```

Health check:

```sh
curl http://localhost:3194/actuator/health
```

Spring Boot manages dependency versions, including Lombok and JUnit, to keep them aligned with the framework. The controller integration tests exercise JSON deserialization and the real service together.
