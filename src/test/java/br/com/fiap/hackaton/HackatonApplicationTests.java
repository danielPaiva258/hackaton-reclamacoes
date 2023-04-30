package br.com.fiap.hackaton;

import br.com.fiap.hackaton.models.Produto;
import br.com.fiap.hackaton.repositories.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HackatonApplicationTests {

	@Autowired
	private ProdutoRepository produtoRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void recupera_informacoes_de_produto_por_id() {
		Integer id = 1;
		Produto produto;
		try {
			produto = produtoRepository.findById(id).get();
		} catch (Exception e){
			produto = new Produto();
		}
		String produtoNome = "Produto 1";
		assertEquals(produtoNome, produto.getNome());
	}

	@Test
	void recupera_informacoes_de_produto_por_nome() {
		Integer id = 1;
		String produtoNome = "Produto 1";
		List<Produto> produtos = produtoRepository.findAllByNome(produtoNome);
		assertEquals(produtos.size(), 1);
		assertEquals(produtos.get(0).getId(), 1);
	}

}
