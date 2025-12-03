package com.controleestoque.api_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.controleestoque.api_estoque.model.Produto;

@Repository
public interface FornecedorRepository extends JpaRepository<Produto, Long>{
}
