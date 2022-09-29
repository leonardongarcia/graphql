package com.garcia.compras.mapper;

import com.garcia.compras.entity.Cliente;
import com.garcia.compras.graphql.input.ClienteInput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

  ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

  Cliente toModel(ClienteInput clienteInput);
}
