package br.com.fiap.hackaton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.fiap.hackaton.models.Atendimento;
import br.com.fiap.hackaton.repositories.AtendimentoRepository;

@SpringBootTest
@ActiveProfiles("test")
class HackatonApplicationTests {

	@Autowired
	private AtendimentoRepository atendimentoRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void recupera_informacoes_de_atendimento_por_id() {
		Integer id = 1;
		Atendimento atendimento = atendimentoRepository.findById(id).get();
		String descricao = "Atendimento via telefone";
		String status = "Concluído";
		Integer id_reclacao = 1;
		assertEquals(descricao, atendimento.getDescricao());
		assertEquals(status, atendimento.getStatus());
		assertEquals(id_reclacao, atendimento.getReclamacao());
	}

	@Test
	void recupera_informacoes_historico_de_atendimento_por_reclamacao() {
		Integer idAtendimento = 1;
		List<Atendimento> atendimentos = atendimentoRepository.findHistoricoAtendimento(idAtendimento);
		Integer qtHistorico = 3;
		assertEquals(atendimentos.size(), qtHistorico);
	}

}
