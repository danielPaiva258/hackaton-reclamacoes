package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hackaton.models.Reclamacao;

public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Integer>{
}
