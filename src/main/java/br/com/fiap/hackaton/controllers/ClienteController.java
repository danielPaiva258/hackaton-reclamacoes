package br.com.fiap.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Cliente;
import br.com.fiap.hackaton.repositories.ClienteRepository;

@RestController()
@RequestMapping(path = "/cliente")
@CrossOrigin(maxAge = 3600)
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/list")
	public List<Cliente> getClientes () {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Cliente getClienteById (@PathVariable Integer id) {
		return clienteRepository.findById(id).get();
	}
	
	@GetMapping()
	public Cliente getClienteByNome (@RequestParam(value="nome") String nome) {
		return clienteRepository.findByName(nome);
	}
}
