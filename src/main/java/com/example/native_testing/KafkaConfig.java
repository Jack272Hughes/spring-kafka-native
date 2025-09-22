package com.example.native_testing;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.List;

@Configuration
public class KafkaConfig {

    @Bean
    public ReactiveKafkaConsumerTemplate<String, String> reactiveKafkaConsumerTemplate(KafkaProperties kafkaProperties) {
        ReceiverOptions<String, String> basicReceiverOptions = ReceiverOptions.<String, String>create(
                        kafkaProperties.buildConsumerProperties(null))
                .subscription(List.of("test-topic"))
                .addAssignListener(receiverPartitions -> System.out.println("onPartitionAssigned " + receiverPartitions))
                .addRevokeListener(receiverPartitions -> System.out.println("onPartitionsRevoked " + receiverPartitions));

        return new ReactiveKafkaConsumerTemplate<>(basicReceiverOptions);
    }
}
