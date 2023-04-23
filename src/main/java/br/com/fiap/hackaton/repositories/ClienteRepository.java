package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.hackaton.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(value = "SELECT * FROM cliente WHERE nome = ?1", nativeQuery = true)
	public Cliente findByName(String nome);
}
