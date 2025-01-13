package com.nota.fiscal.simulated.extern.system.erpcliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nota.fiscal.model.entity.MyMessage;
import com.nota.fiscal.simulated.extern.system.erpcliente.service.kafka.KafkaProducerService;

@RestController
@RequestMapping("/api")
public class ErpNotaFiscalController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@PostMapping("/send")
	public ResponseEntity<String> send(@RequestBody String msg) {
		
		System.out.println("Teste");
		
		kafkaProducerService.sendMessage(msg);
		
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
		
	}

}
