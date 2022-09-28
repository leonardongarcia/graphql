package com.garcia.compras.graphql;

import com.garcia.compras.Cliente;
import com.garcia.compras.Compra;
import com.garcia.compras.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClienteResolver {

  private final CompraService compraService;

  @SchemaMapping(typeName = "Cliente", field = "compras")
  public List<Compra> compras(Cliente cliente) {
    return compraService.findAllByCliente(cliente);
  }
}
