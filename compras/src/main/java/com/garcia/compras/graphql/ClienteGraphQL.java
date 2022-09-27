package com.garcia.compras.graphql;

import com.garcia.compras.Cliente;
import com.garcia.compras.ClienteInput;
import com.garcia.compras.mapper.ClienteMapper;
import com.garcia.compras.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClienteGraphQL {

  private final ClienteService clienteService;

  private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

  @QueryMapping
  public Cliente cliente(@Argument Long id) {
    return clienteService.findById(id);
  }

  @QueryMapping
  public List<Cliente> clientes() {
    return clienteService.findAll();
  }

  @MutationMapping
  public Cliente salvarCliente(@Argument("input") ClienteInput clienteInput) {
    Cliente cliente = clienteMapper.toModel(clienteInput);
    return clienteService.save(cliente);
  }

  @MutationMapping
  public Boolean deletarCliente(@Argument Long id) {
    return clienteService.deleteById(id);
  }
}
