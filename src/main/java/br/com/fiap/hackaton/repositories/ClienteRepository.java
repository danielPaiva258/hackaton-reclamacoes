package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hackaton.models.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    List<Cliente> findAllByNome(String cliName);
}
