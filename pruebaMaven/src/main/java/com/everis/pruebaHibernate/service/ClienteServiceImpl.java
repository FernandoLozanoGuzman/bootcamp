package com.everis.pruebaHibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.everis.pruebaHibernate.DAO.ClienteDAO;
import com.everis.pruebaHibernate.DAO.ClienteInterface;
import com.everis.pruebaHibernate.model.Cliente;

public class ClienteServiceImpl implements ClienteServiceInterface{

	ClienteInterface clienteDAO;
	
	public ClienteServiceImpl(Session session){
		this.clienteDAO=new ClienteDAO(session);
	}

	public List<Cliente> searchClient() {
		List<Cliente> list=new ArrayList<Cliente>();
		list=clienteDAO.searchClient();
		return list;
	}

	public void addCliente(Cliente cliente) {
		if(cliente != null && cliente.getId() == null)
			clienteDAO.addCliente(cliente);
		
	}

	public Cliente searchById(Long id_cliente) {
		Cliente contrato=new Cliente();
		if(id_cliente!=null)
			contrato=clienteDAO.searchById(id_cliente);
		return contrato;
	}

	public void updateCliente(Cliente cliente) {
		if(cliente != null && cliente.getId() != null)
			clienteDAO.updateCliente(cliente);
		
	}

	public void removeCliente(Cliente cliente) {
		if(cliente != null && cliente.getId() != null)
			clienteDAO.removeCliente(cliente);
		
	}
}
