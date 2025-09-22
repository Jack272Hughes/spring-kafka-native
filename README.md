# Testing Spring Boot + GraalVM

## JDK

This project uses GraalVM JDK 21.0.2 community edition.

## Starting application

There is a `./start-all.sh` script to start all the services and run the application.

```bash
./start-all.sh
```

Once everything is started you can send a message to the `test-topic` topic using the Kafka console producer:

```bash
docker exec -it native-testing-kafka-1 bash
/bin/kafka-console-producer --topic test-topic --bootstrap-server 127.0.0.1:9092 --compression-codec zstd
```
