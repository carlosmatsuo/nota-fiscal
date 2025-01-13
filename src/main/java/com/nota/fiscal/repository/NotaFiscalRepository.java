package com.nota.fiscal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nota.fiscal.model.entity.NotaFiscal;



public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
  
	NotaFiscal findByCodigo(String codigo);
	  
}
