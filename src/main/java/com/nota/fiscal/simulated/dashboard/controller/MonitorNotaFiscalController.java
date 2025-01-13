package com.nota.fiscal.simulated.dashboard.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nota.fiscal.model.entity.NotaFiscal;
import com.nota.fiscal.simulated.extern.system.dto.Notas;
import com.nota.fiscal.simulated.extern.system.service.ReactiveNotaFiscalService;
import com.nota.fiscal.simulated.extern.system.service.SimulationHelper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MonitorNotaFiscalController {

	@Autowired
	private ReactiveNotaFiscalService reactiveNotaFiscalService;

	@GetMapping(path = "/monitor/notas_recebidas", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Notas> buildUr() {

		return reactiveNotaFiscalService.notasRecebidas();

	}

	@GetMapping(path = "/monitor/notas_erp", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Notas> antecipacaor() {

		System.out.println("test");

		return reactiveNotaFiscalService.notasErp();
	}

	@RequestMapping("/erpEnviarNotaFiscal")
	public ModelAndView erpEnviarNotaFiscal(ModelMap model) {

		try {

			model.addAttribute("attribute", "redirectWithRedirectPrefix");

			reactiveNotaFiscalService.erpEnviarNotaFiscal();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/", model);
	}

	@RequestMapping("/erpEnviarBoleto")
	public ModelAndView erpEnviarBoleto(ModelMap model) {

		try {

			model.addAttribute("attribute", "redirectWithRedirectPrefix");
			
			//reactiveNotaFiscalService.erpEnviarNotaFiscal();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/", model);
	}

}
