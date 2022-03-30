package com.everis.pruebaHibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.everis.pruebaHibernate.DAO.ContratoDAO;
import com.everis.pruebaHibernate.DAO.ContratoInteface;
import com.everis.pruebaHibernate.model.Contrato;

public class ContratoServiceImpl implements ContratoServiceInterface{

	private ContratoInteface contratoDAO;
	
	public ContratoServiceImpl(Session session){
		this.contratoDAO=new ContratoDAO(session);
	}
	
	public void addContrato(Contrato contrato) {
		if(contrato != null && contrato.getId() == null)
			contratoDAO.addContrato(contrato);
	}

	public List<Contrato> readContratos() {
		List<Contrato> list=new ArrayList<Contrato>();
		
		list= contratoDAO.readContratos();
		return list;
	}

	public Contrato searchById(Long id_contrato) {
		Contrato contrato=new Contrato();
		if(id_contrato!=null){
			contrato=contratoDAO.searchById(id_contrato);
		}
		return contrato;
	}

	public void updateContrato(Contrato contrato) {
		if(contrato != null && contrato.getId() != null)
			contratoDAO.updateContrato(contrato);
		
	}

	public void removeContrato(Contrato contrato) {
		if(contrato != null && contrato.getId() != null)
			contratoDAO.removeContrato(contrato);
		
	}

	public List<Contrato> searchByClient(Long id_cliente) {
		List<Contrato> listContrato=new ArrayList<Contrato>();
		if(id_cliente !=null){
			listContrato=contratoDAO.searchByClient(id_cliente);
		}
		return listContrato;
	}

}
