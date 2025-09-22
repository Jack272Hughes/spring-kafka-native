#!/usr/bin/env bash
set -e

docker compose up -d
./gradlew nativeCompile
./build/native/nativeCompile/native-testing

# docker exec -it native-testing-kafka-1 bash
# /bin/kafka-console-producer --topic test-topic --bootstrap-server 127.0.0.1:9092 --compression-codec zstd
