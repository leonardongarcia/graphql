package com.garcia.compras.repository;

import com.garcia.compras.Produto;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadingConverter
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
