package com.everis.pruebaHibernate.service;

import java.util.List;

import com.everis.pruebaHibernate.model.Cliente;

public interface ClienteServiceInterface {


	public List<Cliente> searchClient(); 
	public void addCliente(Cliente cliente);
	public Cliente searchById(Long id_cliente);
	public void updateCliente(Cliente cliente);
	public void removeCliente(Cliente cliente);
}
