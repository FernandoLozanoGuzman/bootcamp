package com.nttdata.API_Clientes.controller;

import com.nttdata.API_Clientes.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClienteControllerInterface {
    ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente);
    ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente);
    ResponseEntity<List<Cliente>> verClientes();
    ResponseEntity<Cliente> verCliente(@PathVariable Long id);
    ResponseEntity<Cliente> borrarCliente(@PathVariable Long id);


};
