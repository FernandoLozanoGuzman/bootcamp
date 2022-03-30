package com.everis.pruebaHibernate.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.everis.pruebaHibernate.model.Cliente;

public class ClienteDAO implements ClienteInterface{

	private Session session;
	
	public ClienteDAO(Session session){
		this.session=session;
	}
		
	public void addCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		session.save(cliente);
		session.flush();
		
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> searchClient() {
		List<Cliente> res=new ArrayList<Cliente>();
		
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		
		res=session.createNamedQuery("FROM"+Cliente.class).list();
		return res;
	}

	public Cliente searchById(Long id_cliente) {
		// TODO Auto-generated method stub
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		
		Cliente cliente =session.get(Cliente.class, id_cliente);
		return cliente;
	}

	public void updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		
		session.update(cliente);
		
		session.getTransaction().commit();
	}

	public void removeCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		
		session.delete(cliente);		

		session.getTransaction().commit();
	}

}
