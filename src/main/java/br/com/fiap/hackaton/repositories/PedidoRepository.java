package br.com.fiap.hackaton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.hackaton.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query(value = "SELECT * FROM pedido WHERE id_cliente = ?1", nativeQuery = true)
	public List<Pedido> findByCliente(String id_cliente);

}
