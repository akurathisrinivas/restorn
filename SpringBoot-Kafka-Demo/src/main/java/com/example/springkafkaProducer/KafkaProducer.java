package com.example.springkafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springkafkaConstant.ApplicationConstant;
import com.example.springkafkaDto.Student;

@RestController
@RequestMapping("/produce")

public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	/*
	 * @GetMapping("/{message}") public String sendMessage(@PathVariable String
	 * message) {
	 * 
	 * try { kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message); } catch
	 * (Exception e) { e.printStackTrace(); } return "Message sent succuessfully"; }
	 */
	
	@PostMapping("/jsonmessage")
	public String sendMessage(@RequestBody Student message) {

		try {
			kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "json message sent succuessfully";
	}

}
