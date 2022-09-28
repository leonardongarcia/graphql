package com.garcia.compras.graphql;

import com.garcia.compras.Cliente;
import com.garcia.compras.Compra;
import com.garcia.compras.Produto;
import com.garcia.compras.service.ClienteService;
import com.garcia.compras.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CompraResolver {

  private final ClienteService clienteService;
  private final ProdutoService produtoService;

  @SchemaMapping(typeName = "Compra", field = "status")
  public String status(Compra compra) {
    return "Teste : " + compra.getStatus();
  }

  @SchemaMapping(typeName = "Compra")
  public Cliente cliente(Compra compra) {
    return clienteService.findById(compra.getCliente().getId());
  }

  @SchemaMapping(typeName = "Compra")
  public Produto produto(Compra compra) {
    return produtoService.findById(compra.getCliente().getId());
  }
}
