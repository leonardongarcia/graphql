package com.garcia.compras.service;

import com.garcia.compras.Compra;
import com.garcia.compras.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompraService {

  private final CompraRepository compraRepository;

  public Compra findById(Long id) {
    return compraRepository.findById(id).orElse(null);
  }
}
