package br.com.fiap.hackaton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.fiap.hackaton.models.Pagamento;
import br.com.fiap.hackaton.repositories.PagamentoRepository;

@SpringBootTest
@ActiveProfiles("test")
class HackatonApplicationTests {

	@Autowired
	private PagamentoRepository pagamentoRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void recupera_pagamento_por_id() {
		Integer idPagamento = 1;
		Double formaPagamento = 1.0;
		String status = "Aguardando pagamento";
		Double valor = 500.0;
		Double valorFrete = 20.0;
		Double valorParcela = 520.0;
		Integer pedidoID  = 1;

		Pagamento pagamento = pagamentoRepository.findById(idPagamento).get();

		assertEquals(formaPagamento, pagamento.getForma_pagamento());
		assertEquals(status, pagamento.getStatus());
		assertEquals(valor, pagamento.getValor());
		assertEquals(valorFrete, pagamento.getValor_frete());
		assertEquals(valorParcela, pagamento.getValor_parcela());
		assertEquals(pedidoID, pagamento.getPedido_id());

	}

	@Test
	void recupera_pagamentos_por_pedido() {
		Integer idPedido = 1;
		Integer qtPagamentos = 1;
		List<Pagamento> pagamentos = pagamentoRepository.getPagamentosByPedido(idPedido);
		assertEquals(pagamentos.size(), qtPagamentos);
	}

}
