package com.garcia.compras.graphql;

import com.garcia.compras.Compra;
import com.garcia.compras.CompraInput;
import com.garcia.compras.mapper.CompraMapper;
import com.garcia.compras.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompraGraphQL {

  private final CompraService compraService;
  private final CompraMapper compraMapper = CompraMapper.INSTANCE;

  @QueryMapping
  public Compra compra(@Argument Long id) {
    return compraService.findById(id);
  }

  @QueryMapping
  public List<Compra> compras() {
    return compraService.findAll();
  }

  @MutationMapping
  public Compra salvarCompra(@Argument("input") CompraInput compraInput) {
    Compra compra = compraMapper.toModel(compraInput);
    return compraService.save(compra);
  }

  @MutationMapping
  public Boolean deletarCompra(@Argument Long id) {
    return compraService.deleteById(id);
  }
}
