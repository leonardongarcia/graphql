package com.garcia.compras;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInput {

  private Long id;
  private String nome;
  private String email;
}
