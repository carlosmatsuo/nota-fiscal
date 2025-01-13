package com.nota.fiscal.simulated.extern.system.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nota.fiscal.model.entity.NotaFiscal;

public class SimulationHelper {

	private Integer index;

	private List<NotaFiscal> notas = new ArrayList<NotaFiscal>();

	public SimulationHelper() {

		index = 0;

		NotaFiscal nf = null;

		nf = new NotaFiscal(1, "123", "Alberto", "Walter", false, false);
		notas.add(nf);

		nf = new NotaFiscal(2, "456", "Eduardo", "Vania", false, false);
		notas.add(nf);

		nf = new NotaFiscal(3, "789", "Flavia", "Maria", false, false);
		notas.add(nf);
		
		Collections.sort(notas);

	}

	public List<NotaFiscal> getNotas() {
		return notas;
	}

	public void setNotas(List<NotaFiscal> notas) {
		this.notas = notas;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void incrementIndex() {
		index = index + 1;
	}
}
