package com.garcia.compras.graphql;

import com.garcia.compras.Produto;
import com.garcia.compras.ProdutoInput;
import com.garcia.compras.mapper.ProdutoMapper;
import com.garcia.compras.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProdutoGraphQL {

  private final ProdutoService produtoService;
  private final ProdutoMapper produtoMapper = ProdutoMapper.INSTANCE;

  @QueryMapping
  public Produto produto(@Argument Long id) {
    return produtoService.findById(id);
  }

  @QueryMapping
  public List<Produto> produtos() {
    return produtoService.findAll();
  }

  @MutationMapping
  public Produto salvarProduto(@Argument("input") ProdutoInput produtoInput) {
    Produto produto = produtoMapper.toModel(produtoInput);
    return produtoService.save(produto);
  }

  @MutationMapping
  public Boolean deletarProduto(@Argument Long id) {
    return produtoService.deleteById(id);
  }
}
