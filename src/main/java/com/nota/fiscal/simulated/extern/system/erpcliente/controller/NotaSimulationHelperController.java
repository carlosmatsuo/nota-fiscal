package com.nota.fiscal.simulated.extern.system.erpcliente.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaSimulationHelperController {

	@PostMapping("/helper")
	public ResponseEntity<String> helper(@RequestBody String simpleMsg) {
		
		System.out.println("Teste");
		
		
		
		return new ResponseEntity<>(simpleMsg, HttpStatus.CREATED);
		
	}
	
}
