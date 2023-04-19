package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hackaton.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>{

}
