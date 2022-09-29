package com.garcia.compras.graphql.input;

import lombok.Data;

@Data
public class ProdutoInput {

  private Long id;
  private String nome;
  private double valor;
}
