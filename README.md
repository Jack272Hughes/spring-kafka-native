# Testing Spring Boot + GraalVM

## Pre-Requisites

- GraalVM JDK 21.0.2 community edition
- Docker

## Starting application

Run these commands to set up the kafka cluster and compile the native image:

```bash
docker compose up -d
./gradlew nativeCompile
./build/native/nativeCompile/native-testing
```

Once everything is started you can send a message to the `test-topic` topic using the Kafka console producer:

```bash
docker exec -it spring-kafka-native-kafka-1
/bin/kafka-console-producer --topic test-topic --bootstrap-server 127.0.0.1:9092 --compression-codec zstd
# Type something and press Enter
```
