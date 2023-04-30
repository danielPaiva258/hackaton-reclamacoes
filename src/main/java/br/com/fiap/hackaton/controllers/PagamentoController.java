package br.com.fiap.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Pagamento;
import br.com.fiap.hackaton.repositories.PagamentoRepository;

@RestController()
@RequestMapping(path = "/pagamento")
@CrossOrigin(maxAge = 3600)
public class PagamentoController {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@GetMapping("/list")
	public List<Pagamento> getPagamentos () {
		return pagamentoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pagamento getPagamentoById (@PathVariable Integer id) {
		return pagamentoRepository.findById(id).get();
	}
	
	@GetMapping(params = "id_pedido")
	public List<Pagamento> getPagamentoByPedido (@RequestParam(value="id_pedido") Integer pedido_id) {
		return pagamentoRepository.getPagamentosByPedido(pedido_id);
	}
}
