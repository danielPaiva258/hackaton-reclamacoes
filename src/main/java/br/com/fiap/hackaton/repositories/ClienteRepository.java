package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hackaton.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
