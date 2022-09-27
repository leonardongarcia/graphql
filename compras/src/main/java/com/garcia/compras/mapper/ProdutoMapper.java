package com.garcia.compras.mapper;

import com.garcia.compras.Produto;
import com.garcia.compras.ProdutoInput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

  ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

  Produto toModel(ProdutoInput produtoInput);
}
