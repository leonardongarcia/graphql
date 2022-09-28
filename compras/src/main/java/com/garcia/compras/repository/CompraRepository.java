package com.garcia.compras.repository;

import com.garcia.compras.Cliente;
import com.garcia.compras.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
  List<Compra> findAllByCliente(Cliente cliente);
}
