package com.example.native_testing;

import jakarta.annotation.PostConstruct;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerPrinter {

    private final ReactiveKafkaConsumerTemplate<String, String> kafkaConsumer;

    public KafkaConsumerPrinter(ReactiveKafkaConsumerTemplate<String, String> kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @PostConstruct
    public void printMessages() {
        kafkaConsumer.receive()
                .doOnNext(record -> System.out.println(record.value()))
                .subscribe();
    }
}
