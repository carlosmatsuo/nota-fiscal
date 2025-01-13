package com.nota.fiscal.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal implements Comparable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "emissor")
	private String emissor;

	@Column(name = "receptor")
	private String receptor;

	@Column(name = "published")
	private boolean published;

	@Column(name = "boletook")
	private boolean boletoOk;

	private boolean boletoEnviado;

	public NotaFiscal() {

	}

	public NotaFiscal(String codigo, String emissor, String receptor, boolean published) {

		this.codigo = codigo;
		this.emissor = emissor;
		this.receptor = receptor;
		this.published = published;

	}

	public NotaFiscal(long id, String codigo, String emissor, String receptor, boolean published,
			boolean boletoEnviado) {

		this.id = id;
		this.codigo = codigo;
		this.emissor = emissor;
		this.receptor = receptor;
		this.published = published;
		this.boletoEnviado = boletoEnviado;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public boolean isPublished() {
		return published;
	}

	public boolean isBoletoOk() {
		return boletoOk;
	}

	public void setBoletoOk(boolean boletoOk) {
		this.boletoOk = boletoOk;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public boolean isBoletoEnviado() {
		return boletoEnviado;
	}

	public void setBoletoEnviado(boolean boletoEnviado) {
		this.boletoEnviado = boletoEnviado;
	}

	@Override
	public int compareTo(Object o) {

		NotaFiscal obj = (NotaFiscal) o;

		if (this.getId() > obj.getId()) {
			return 1;
		}

		if (this.getId() == obj.getId()) {
			return 0;
		}

		return -1;
	}

}