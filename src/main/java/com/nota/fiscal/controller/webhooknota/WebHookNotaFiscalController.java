package com.nota.fiscal.controller.webhooknota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nota.fiscal.model.entity.NotaFiscal;
import com.nota.fiscal.service.NotaFiscalService;



@RestController
public class WebHookNotaFiscalController {

	@Autowired
	private NotaFiscalService notaFiscalService;
	
	@PostMapping(value = "/hook_notafiscal", consumes = "application/json", produces = "application/json")
	public ResponseEntity<NotaFiscal> createTutorial(@RequestBody NotaFiscal notaFiscal) {
		try {
			
			notaFiscalService.gravarNotaFical(notaFiscal);
			
			return new ResponseEntity<>(notaFiscal, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
