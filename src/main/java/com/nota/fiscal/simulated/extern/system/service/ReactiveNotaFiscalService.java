package com.nota.fiscal.simulated.extern.system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nota.fiscal.model.entity.NotaFiscal;
import com.nota.fiscal.service.NotaFiscalService;
import com.nota.fiscal.simulated.extern.system.dto.NotaFiscalErp;
import com.nota.fiscal.simulated.extern.system.dto.Notas;

import reactor.core.publisher.Flux;

@Service
public class ReactiveNotaFiscalService {

	private SimulationHelper notasErp = new SimulationHelper();

	@Autowired
	private NotaFiscalService notaFiscalService;

	public Flux<Notas> notasErp() {

		Notas n = new Notas();
		n.setNotas(notasErp.getNotas());
		List<Notas> list = new ArrayList<Notas>();
		list.add(n);
		return Flux.fromIterable(list);

	}

	public Flux<Notas> notasRecebidas() {

		try {

			List<NotaFiscal> listBaseDadoa = notaFiscalService.obterNotas();

			Notas n = new Notas();
			n.setNotas(listBaseDadoa);
			List<Notas> list2 = new ArrayList<Notas>();
			list2.add(n);

			return Flux.fromIterable(list2);

		} catch (Exception e) {
			// erro
		}

		return Flux.fromIterable(new ArrayList<Notas>());
	}

	public void erpEnviarNotaFiscal() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		NotaFiscal nfErp = null;

		for (NotaFiscal nf : notasErp.getNotas()) {

			if (!nf.isPublished()) {
				nfErp = nf;
				nf.setPublished(true);
				break;
			}

		}

		if (nfErp != null) {

			HttpEntity<NotaFiscal> request = new HttpEntity<>(nfErp);
			restTemplate.postForObject("http://localhost:8080/hook_notafiscal", request, NotaFiscal.class);

		} else {
			throw new Exception("Não Há Nota Fiscal");
		}

	}
	
	public void erpEnviarBoleto() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		NotaFiscal nfErp = null;

		for (NotaFiscal nf : notasErp.getNotas()) {

			if (!nf.isBoletoEnviado()) {
				nfErp = nf;
				nf.setBoletoEnviado(true);
				break;
			}

		}

		if (nfErp != null) {

			HttpEntity<NotaFiscal> request = new HttpEntity<>(nfErp);
			restTemplate.postForObject("http://localhost:8080/hook_notafiscal", request, NotaFiscal.class);

		} else {
			throw new Exception("Não Há Nota Fiscal");
		}

	}

}
