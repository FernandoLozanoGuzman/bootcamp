package com.everis.pruebaHibernate.DAO;

import java.util.List;

import com.everis.pruebaHibernate.model.Cliente;

public interface ClienteInterface {
	
	public List<Cliente> searchClient(); 
	public void addCliente(Cliente cliente);
	public Cliente searchById(Long id_cliente);
	public void updateCliente(Cliente cliente);
	public void removeCliente(Cliente cliente);

}
