package com.everis.pruebaHibernate.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.everis.pruebaHibernate.model.Cliente;
import com.everis.pruebaHibernate.model.Contrato;
import com.everis.pruebaHibernate.service.ClienteServiceImpl;
import com.everis.pruebaHibernate.service.ClienteServiceInterface;
import com.everis.pruebaHibernate.service.ContratoServiceImpl;
import com.everis.pruebaHibernate.service.ContratoServiceInterface;
import com.everis.pruebaHibernate.utils.HibernateUtils;

public class Hibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Session session = HibernateUtils.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClienteServiceInterface clienteService = new ClienteServiceImpl(session);
		final ContratoServiceInterface contratoService = new ContratoServiceImpl(session);

		//Cliente 1.
		Cliente cliente1 = new Cliente();
		cliente1.setDNI("11111111A");
		cliente1.setNombre("Fernando");
		cliente1.setPrimerApellido("Lozano");
		cliente1.setSegundoApellido("Guzmán");
		cliente1.setContrato(null);


		//Cliente 2.
		Cliente cliente2 = new Cliente();
		cliente2.setDNI("22222222B");
		cliente2.setNombre("Christian");
		cliente2.setPrimerApellido("Rebolledo");
		cliente2.setSegundoApellido("Becker");
		cliente2.setContrato(null);


		//Cliente 3.
		Cliente cliente3 = new Cliente();
		cliente3.setDNI("33333333C");
		cliente3.setNombre("Miguel");
		cliente3.setPrimerApellido("Alcantara");
		cliente3.setSegundoApellido("Montero");
		cliente3.setContrato(null);

		//Contrato 1.
		Contrato contrato1=new Contrato();
		contrato1.setFechaVigencia(new Date(2022, 03, 15));
		contrato1.setFecahCaducidad(new Date(2022, 06, 15));
		contrato1.setPrecio(850.3);
		contrato1.setCliente(cliente1);


		//Contrato 2.
		Contrato contrato2=new Contrato();
		contrato2.setFechaVigencia(new Date(2022, 03, 15));
		contrato2.setFecahCaducidad(new Date(2022, 06, 15));
		contrato2.setPrecio(850.5);
		contrato2.setCliente(cliente2);

		//Contrato 3.
		Contrato contrato3=new Contrato();
		contrato3.setFechaVigencia(new Date(2022, 03, 15));
		contrato3.setFecahCaducidad(new Date(2022, 06, 15));
		contrato3.setPrecio(1003);
		contrato3.setCliente(cliente3);

		//Actualizacion clientes
		cliente1.setContrato(contrato1);
		cliente2.setContrato(contrato2);
		cliente3.setContrato(contrato3);

		// Insercción de contratos.
		contratoService.addContrato(contrato1);
		contratoService.addContrato(contrato2);
		contratoService.addContrato(contrato3);

		//Inserccion de clientes
		clienteService.addCliente(cliente1);
		clienteService.addCliente(cliente2);
		clienteService.addCliente(cliente3);

		// Obtención de la lista de contratos insertados.
		List<Contrato> lista_contratos = contratoService.readContratos();
		if (lista_contratos != null && lista_contratos.size() > 0) {
			System.out.println("Total de contratos: " + lista_contratos.size());
			for (int i=0;i<lista_contratos.size();i++) 
				System.out.println("\t"+lista_contratos.get(i).toString() + "\n");
		}

		// Obtención de la lista de clientes insertados.
		List<Cliente> lista_clientes = clienteService.searchClient();
		if (lista_clientes != null && lista_clientes.size() > 0) {
			System.out.println("Total de clientes: " + lista_clientes.size());
			for (int i=0;i<lista_clientes.size();i++) 
				System.out.println("\t"+lista_clientes.get(i).toString() + "\n");
		}


		// Obtención de contratos asociados a un cliente.
		final List<Contrato> list_contratos_cliente = contratoService.searchByClient(cliente1.getId());

		if (list_contratos_cliente != null && list_contratos_cliente.size() > 0) {
			System.out.println("Total de contratos asociados al cliente " + cliente1.getNombre() + ": " + list_contratos_cliente.size());
			for (int i=0;i<list_contratos_cliente.size();i++) 
				System.out.println("\t"+list_contratos_cliente.get(i).toString() + "\n");
		}

		// Cierre de sesión.
		session.close();
	}

}
