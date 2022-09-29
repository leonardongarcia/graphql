package com.garcia.compras.graphql;

import com.garcia.compras.entity.Produto;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProdutoResolver {

  @SchemaMapping(typeName = "Produto")
  public String valorReais(Produto produto) {
    return "R$" + produto.getValor();
  }
}
