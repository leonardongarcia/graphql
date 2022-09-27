package com.garcia.compras.graphql;

import com.garcia.compras.Compra;
import com.garcia.compras.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CompraGraphQL {

  private final CompraService compraService;

  @QueryMapping
  public Compra compra(@Argument Long id) {
    return compraService.findById(id);
  }
}
