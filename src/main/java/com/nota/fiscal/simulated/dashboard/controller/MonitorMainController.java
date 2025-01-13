package com.nota.fiscal.simulated.dashboard.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

import reactor.core.publisher.Mono;

@Controller
public class MonitorMainController {

	@GetMapping("/")
	public String index(final Model model, @ModelAttribute TestForm testForm) {

		testForm.setDataLancamentoInicial("02/08/2024");
		testForm.setInicial(new Date());

		model.addAttribute("testForm", testForm);

		return "dashboard/dashboard";
	}

}
