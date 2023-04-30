package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.hackaton.models.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	@Query(value = "SELECT COUNT(id_produto) FROM produto_pedido WHERE id_produto = ?1", nativeQuery = true)
	public Integer getQuantidadeVendas(Integer id);

    List<Produto> findAllByNome(String produtoNome);

	@Query(value = "SELECT id_pedido FROM produto_pedido WHERE id_produto = ?1", nativeQuery = true)
	public List<Integer> findPedidosProduto(Integer id_produto);

}
