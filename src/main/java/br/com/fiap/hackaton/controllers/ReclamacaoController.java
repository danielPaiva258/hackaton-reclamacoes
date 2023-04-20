package br.com.fiap.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Reclamacao;
import br.com.fiap.hackaton.repositories.ReclamacaoRepository;

@RestController()
@RequestMapping(path = "/reclamacao")
@CrossOrigin(maxAge = 3600)
public class ReclamacaoController {

	@Autowired
	private ReclamacaoRepository reclamacaoRepository;
	
	@GetMapping("/list")
	public List<Reclamacao> getReclamacoes () {
		return reclamacaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Reclamacao getReclamacaoById (@PathVariable Integer id) {
		return reclamacaoRepository.findById(id).get();
	}
}
