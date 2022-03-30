package com.everis.pruebaHibernate.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.everis.pruebaHibernate.model.Contrato;

public class ContratoDAO implements ContratoInteface{

	private Session session;

	public ContratoDAO(Session session){
		this.session=session;
	}

	public void addContrato(Contrato contrato) {
		// TODO Auto-generated method stub
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		session.save(contrato);
		session.flush();
		
		session.getTransaction().commit();
	}

	public List<Contrato> readContratos() {
		// TODO Auto-generated method stub
		List<Contrato> res=new ArrayList<Contrato>();

		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}

		res=session.createNamedQuery("FROM"+Contrato.class).list();
		return res;
	}

	public Contrato searchById(Long id_contrato) {
		// TODO Auto-generated method stub
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		
		Contrato contrato =session.get(Contrato.class, id_contrato);
		return contrato;
	}

	public void updateContrato(Contrato contrato) {
		// TODO Auto-generated method stub
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		
		session.update(contrato);
		
		session.getTransaction().commit();
	}

	public void removeContrato(Contrato contrato) {
		// TODO Auto-generated method stub
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		
		session.delete(contrato);		

		session.getTransaction().commit();
	}

	public List<Contrato> searchByClient(Long id_cliente) {
		// TODO Auto-generated method stub
		List<Contrato> listContrato=new ArrayList<Contrato>();
		
		if(!session.getTransaction().isActive()){
			session.getTransaction().begin();
		}
		listContrato=session.createQuery("FROM "+Contrato.class+" WHERE CLIENTE_CONTRATO=" + id_cliente).list();
			
		return listContrato;
	}

}
