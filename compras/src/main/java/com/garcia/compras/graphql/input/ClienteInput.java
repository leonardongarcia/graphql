package com.garcia.compras.graphql.input;

import lombok.Data;

@Data
public class ClienteInput {

  private Long id;
  private String nome;
  private String email;
}
