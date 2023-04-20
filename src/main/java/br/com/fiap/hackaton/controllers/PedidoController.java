package br.com.fiap.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Pedido;
import br.com.fiap.hackaton.repositories.PedidoRepository;

@RestController()
@RequestMapping(path = "/pedido")
@CrossOrigin(maxAge = 3600)
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/list")
	public List<Pedido> getPedidos () {
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pedido getPedidoById (@PathVariable Integer id) {
		return pedidoRepository.findById(id).get();
	}
}
