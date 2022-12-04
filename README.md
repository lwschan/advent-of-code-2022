# Advent of Code Java

## Requirements

- openjdk17

## How to

### Build the project

```shell
./mvnw clean install -DskipTests
```

### Run the project with debugging

1. Build the project
2. Run the project with debugging port open
   ```shell
   java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar target\adventofcode-0.0.1-SNAPSHOT.jar
   ```
3. Attach debugger in IntelliJ using the configuration `Attach to Debugger`
4. Run command in the interactive shell started in step 2, using keys from `CommandKeys.java`
   ```shell
   shell:> 22-01 
   ```

### Run the project without debugging

```shell
make run day="{one-of-the-keys-from-CommandKeys.java}"
```
