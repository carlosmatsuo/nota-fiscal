package com.nota.fiscal.simulated.extern.system.erpcliente.service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nota.fiscal.model.entity.MyMessage;

@Service
public class KafkaProducerService {

	//private final KafkaTemplate<String, String> kafkaTemplate;
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String TOPIC_NAME = "topic1";

	public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		kafkaTemplate.send(TOPIC_NAME, message);
		System.out.println("Message " + message + " has been sucessfully sent to the topic: " + TOPIC_NAME);
	}

}
