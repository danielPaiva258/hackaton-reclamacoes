package br.com.fiap.hackaton;

import br.com.fiap.hackaton.models.Reclamacao;
import br.com.fiap.hackaton.repositories.ReclamacaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
class HackatonApplicationTests {

	@Autowired
	private ReclamacaoRepository reclamacaoRepository;


	@Test
	void contextLoads() {
		log("Testes de contexto OK!");
	}

	@Test
	void recupera_reclamacao_por_id() {
		log("Iniciando teste: Recupera Reclamação por ID");
		Integer id = 1;
		log("1- Recuperando a reclamação...");
		Reclamacao reclamacao = reclamacaoRepository.findById(id).get();
		log("2 - Preparando dados para comparacação");
		String origem = "Telefone";
		String status = "Aberta";
		String titulo = "Problema com a linha";
		Integer idCliente = 1;

		log("3 - Comparações");

		assertEquals(origem, reclamacao.getOrigem());
		assertEquals(status, reclamacao.getStatus());
		assertEquals(titulo, reclamacao.getTitulo());
		assertEquals(idCliente, reclamacao.getIdCliente());

	}

	private void log(String msg){
		//System.out.println(String.format("LOG: %s", msg));
	}


}
