package com.garcia.compras.service;

import com.garcia.compras.entity.Produto;
import com.garcia.compras.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

  private final ProdutoRepository produtoRepository;

  public Produto findById(Long id) {
    return produtoRepository.findById(id).orElse(null);
  }

  public List<Produto> findAll() {
    return produtoRepository.findAll();
  }

  public Produto save(Produto produto) {
    return produtoRepository.save(produto);
  }

  public Boolean deleteById(Long id) {
    if (produtoRepository.existsById(id)) {
      produtoRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
