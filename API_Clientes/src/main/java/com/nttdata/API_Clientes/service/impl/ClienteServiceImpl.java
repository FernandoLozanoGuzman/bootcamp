package com.nttdata.API_Clientes.service.impl;

import com.nttdata.API_Clientes.model.Cliente;
import com.nttdata.API_Clientes.repository.ClienteRepository;
import com.nttdata.API_Clientes.service.ClienteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteServiceInterface {


    @Autowired
    ClienteRepository clienteRepository;

    public Cliente guardarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        return clienteRepository.save(cliente);
    }

    public List<Cliente> verTodosClientes() {
        // TODO Auto-generated method stub
        return clienteRepository.findAll();
    }

    public List<Cliente> buscarNombreApellidos(String nombre, String apellido) {
        // TODO Auto-generated method stub
        return clienteRepository.findByNombreAndApellidos(nombre, apellido);
    }

    public void borrarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        clienteRepository.delete(cliente);
    }

    public Cliente buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente crearCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        return clienteRepository.save(cliente);
    }
}
