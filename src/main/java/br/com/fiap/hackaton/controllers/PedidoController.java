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
	public List<Pedido> getPedidos() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		pedidos = incluiProdutos(pedidos);
		return pedidos;
	}

	@GetMapping("/{id}")
	public Pedido getPedidoById(@PathVariable Integer id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		pedido = incluiProdutos(pedido);
		return pedido;
	}

	@GetMapping(params = "id_cliente")
	public List<Pedido> getPedidosByCliente(@RequestParam(value = "id_cliente") String id_cliente) {
		List<Pedido> pedidos = pedidoRepository.findByCliente(id_cliente);
		pedidos = incluiProdutos(pedidos);
		return pedidos;
	}

	private List<Pedido> incluiProdutos(List<Pedido> pedidos) {
		for (Pedido pedido : pedidos) {
			pedido.setProdutos(pedidoRepository.findProdutosPedido(pedido.getId()).stream()
					.map(produtoId -> new Produto(produtoId)).toList());
		}
		return pedidos;
	}

	private Pedido incluiProdutos(Pedido pedido) {
		pedido.setProdutos(pedidoRepository.findProdutosPedido(pedido.getId()).stream()
				.map(produtoId -> new Produto(produtoId)).toList());
		return pedido;
	}
}
