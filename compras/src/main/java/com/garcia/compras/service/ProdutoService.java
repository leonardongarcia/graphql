package com.garcia.compras.service;

import com.garcia.compras.Produto;
import com.garcia.compras.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

  private final ProdutoRepository produtoRepository;

  public Produto findById(Long id) {
    return produtoRepository.findById(id).orElse(null);
  }
}
