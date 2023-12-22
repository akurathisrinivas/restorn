package com.example.springkafkaConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.springkafkaConstant.ApplicationConstant;
import com.example.springkafkaDto.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	/*
		 * @KafkaListener(groupId = ApplicationConstant.GROUP_ID_STRING, topics =
		 * ApplicationConstant.TOPIC_NAME, containerFactory =
		 * ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY) public void
		 * receivedMessage(String message) {
		 * logger.info("Message Received using Kafka listener " + message); }
		 */
	
	@KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_NAME, 
			containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
	public void receivedMessage(Student message) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(message);
		logger.info("Json message received using Kafka listener " + jsonString);
	}

}
