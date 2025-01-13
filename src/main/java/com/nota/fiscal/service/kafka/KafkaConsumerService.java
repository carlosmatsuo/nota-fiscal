package com.nota.fiscal.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

	@KafkaListener(topics = "topic1", groupId = "group1")
	public void consumeMessage(String message) {

		System.out.println("Received message: " + message);

	}

}
