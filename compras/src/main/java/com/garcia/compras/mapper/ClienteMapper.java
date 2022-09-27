package com.garcia.compras.mapper;

import com.garcia.compras.Cliente;
import com.garcia.compras.ClienteInput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

  ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

//  ClienteInput toInput(Cliente cliente);

  Cliente toModel(ClienteInput clienteInput);
}
