package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hackaton.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
