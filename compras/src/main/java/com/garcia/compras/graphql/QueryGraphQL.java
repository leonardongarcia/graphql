package com.garcia.compras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class QueryGraphQL {

  @Autowired private ClienteRepository clienteRepository;

  @QueryMapping
  public String hello() {
    return "Hello, GraphQL";
  }

  @QueryMapping
  public int soma(@Argument int a, @Argument int b) {
    return a + b;
  }

  @QueryMapping
  public Cliente cliente(@Argument Long id) {
    return clienteRepository.findById(id).orElse(null);
  }

  @QueryMapping
  public List<Cliente> clientes() {
    return clienteRepository.findAll();
  }
}
