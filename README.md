# Advent of Code Java

## Requirements

- openjdk17

## How to run

### Build the project

```shell
./mvnw clean install -DskipTests
```

### Run the project with debugger

```shell
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar target\adventofcode-0.0.1-SNAPSHOT.jar
```
