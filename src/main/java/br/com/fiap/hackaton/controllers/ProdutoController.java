package br.com.fiap.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Produto;
import br.com.fiap.hackaton.repositories.ProdutoRepository;

@RestController()
@RequestMapping(path = "/produto")
@CrossOrigin(maxAge = 3600)
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/list")
	public List<Produto> getProdutos () {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Produto getProdutoById (@PathVariable Integer id) {
		return produtoRepository.findById(id).get();
	}
}
