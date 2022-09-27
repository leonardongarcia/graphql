package com.garcia.compras.graphql;

import com.garcia.compras.Produto;
import com.garcia.compras.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProdutoGraphQL {

  private final ProdutoService produtoService;

  @QueryMapping
  public Produto produto(@Argument Long id) {
    return produtoService.findById(id);
  }
}
