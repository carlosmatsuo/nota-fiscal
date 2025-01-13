package com.nota.fiscal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nota.fiscal.model.entity.NotaFiscal;
import com.nota.fiscal.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	public void gravarNotaFical(NotaFiscal notaFiscal) throws Exception {

		try {

			NotaFiscal nf = new NotaFiscal(notaFiscal.getCodigo(), notaFiscal.getEmissor(), notaFiscal.getReceptor(),
					false);

			notaFiscalRepository.save(nf);

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public List<NotaFiscal> obterNotas() throws Exception {

		try {

			return notaFiscalRepository.findAll();

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

}
