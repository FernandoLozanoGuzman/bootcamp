package com.nttdata.API_Clientes.service;

import com.nttdata.API_Clientes.model.Cliente;

import java.util.List;

public interface ClienteServiceInterface {

    Cliente guardarCliente(Cliente cliente);

    List<Cliente> verTodosClientes();

    List<Cliente> buscarNombreApellidos(String nombre, String apellido);

    void borrarCliente(Cliente cliente);

    Cliente buscarPorId(Long id);

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);
}
