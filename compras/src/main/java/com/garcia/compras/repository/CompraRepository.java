package com.garcia.compras.repository;

import com.garcia.compras.entity.Cliente;
import com.garcia.compras.entity.Compra;
import com.garcia.compras.graphql.dto.CompraResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
  List<Compra> findAllByCliente(Cliente cliente);

  @Query(
      "select new com.garcia.compras.graphql.dto.CompraResumo(c.id, cli.nome, p.nome, c.quantidade) from Compra c inner join c.cliente cli inner join c.produto p")
  List<CompraResumo> findAllComprasRelatorio();
}
