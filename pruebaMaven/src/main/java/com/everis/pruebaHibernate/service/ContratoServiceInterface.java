package com.everis.pruebaHibernate.service;

import java.util.List;

import com.everis.pruebaHibernate.model.Contrato;

public interface ContratoServiceInterface {


	public void addContrato(Contrato contrato);
	public List<Contrato> readContratos();
	public Contrato searchById(Long id_contrato);
	public void updateContrato(Contrato contrato);
	public void removeContrato(Contrato contrato);
	public List<Contrato> searchByClient(Long id_cliente);
}
