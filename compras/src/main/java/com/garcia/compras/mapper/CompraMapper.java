package com.garcia.compras.mapper;

import com.garcia.compras.entity.Compra;
import com.garcia.compras.graphql.input.CompraInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompraMapper {

  CompraMapper INSTANCE = Mappers.getMapper(CompraMapper.class);

  @Mapping(target = "produto.id", source = "produtoId")
  @Mapping(target = "cliente.id", source = "clienteId")
  Compra toModel(CompraInput compraInput);
}
