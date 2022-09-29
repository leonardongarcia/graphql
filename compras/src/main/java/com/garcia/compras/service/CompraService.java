package com.garcia.compras.service;

import com.garcia.compras.entity.Cliente;
import com.garcia.compras.entity.Compra;
import com.garcia.compras.graphql.dto.CompraResumo;
import com.garcia.compras.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {

  private final CompraRepository compraRepository;

  public Compra findById(Long id) {
    return compraRepository.findById(id).orElse(null);
  }

  public List<Compra> findAll(Pageable pageable) {
    Page<Compra> comprasPage = compraRepository.findAll(pageable);
    return comprasPage.getContent();
  }

  public List<Compra> findAllByCliente(Cliente cliente) {
    return compraRepository.findAllByCliente(cliente);
  }

  public Compra save(Compra compra) {
    compra.setData(LocalDate.now());
    return compraRepository.save(compra);
  }

  public Boolean deleteById(Long id) {
    if (compraRepository.existsById(id)) {
      compraRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public List<CompraResumo> findAllComprasRelatorio() {
    return compraRepository.findAllComprasRelatorio();
  }
}
