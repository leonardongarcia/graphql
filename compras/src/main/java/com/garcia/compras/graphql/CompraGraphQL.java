package com.garcia.compras.graphql;

import com.garcia.compras.entity.Compra;
import com.garcia.compras.graphql.input.CompraInput;
import com.garcia.compras.graphql.dto.CompraResumo;
import com.garcia.compras.mapper.CompraMapper;
import com.garcia.compras.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
  public List<Compra> compras(@Argument int page, @Argument int size) {
    return compraService.findAll(PageRequest.of(page, size));
  }

  @QueryMapping
  public List<CompraResumo> comprasRelatorio() {
    return compraService.findAllComprasRelatorio();
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
