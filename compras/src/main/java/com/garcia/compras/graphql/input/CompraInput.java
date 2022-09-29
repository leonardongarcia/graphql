package com.garcia.compras.graphql.input;

import lombok.Data;

@Data
public class CompraInput {

  private Long id;
  private int quantidade;
  private String status;
  private Long clienteId;
  private Long produtoId;
}
