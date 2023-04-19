package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hackaton.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
