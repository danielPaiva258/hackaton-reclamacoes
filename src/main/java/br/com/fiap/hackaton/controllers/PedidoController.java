package br.com.fiap.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Pedido;
import br.com.fiap.hackaton.models.Produto;
import br.com.fiap.hackaton.repositories.PedidoRepository;

@RestController()
@RequestMapping(path = "/pedido")
@CrossOrigin(maxAge = 3600)
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/list")
	public List<Pedido> getPedidos () {
		List<Pedido> pedidos = pedidoRepository.findAll();
		for (Pedido pedido : pedidos) {
			pedido.setProdutos(
					pedidoRepository.findProdutosPedido(pedido.getId()).stream().map(produtoId -> new Produto(produtoId)).toList()
					);
		}
		return pedidoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Pedido getPedidoById (@PathVariable Integer id) {
		return pedidoRepository.findById(id).get();
	}
	
	@GetMapping(params = "id_cliente")
	public List<Pedido> getPedidosByCliente (@RequestParam(value="id_cliente") String id_cliente) {
		return pedidoRepository.findByCliente(id_cliente);
	}
}
