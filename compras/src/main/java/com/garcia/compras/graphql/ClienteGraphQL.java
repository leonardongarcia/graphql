package com.garcia.compras.graphql;

import com.garcia.compras.Cliente;
import com.garcia.compras.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
public class ClienteGraphQL {

  @Autowired private ClienteService clienteService;

  @QueryMapping
  public Cliente cliente(@Argument Long id) {
    return clienteService.findById(id);
  }

  @QueryMapping
  public List<Cliente> clientes() {
    return clienteService.findAll();
  }

  @MutationMapping
  public Cliente save(@Argument Long id, @Argument String nome, @Argument String email) {
    Cliente cliente = new Cliente();
    cliente.setId(id);
    cliente.setNome(nome);
    cliente.setEmail(email);
    return clienteService.save(cliente);
  }

  @MutationMapping
  public Boolean delete(@Argument Long id) {
    return clienteService.deleteById(id);
  }
}
