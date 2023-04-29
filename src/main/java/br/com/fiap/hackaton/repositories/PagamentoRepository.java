package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.hackaton.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

	@Query(value = "SELECT * FROM pagamento WHERE pedido_id = ?1", nativeQuery = true)
	public Pagamento getPagamentoByPedido(String id_pedido);

}
