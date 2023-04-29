package br.com.fiap.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Atendimento;
import br.com.fiap.hackaton.repositories.AtendimentoRepository;

@RestController()
@RequestMapping(path = "/atendimento")
@CrossOrigin(maxAge = 3600)
public class AtendimentoController {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@GetMapping("/list")
	public List<Atendimento> getAtendimento () {
		return atendimentoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Atendimento getAtendimentoById (@PathVariable Integer id) {
		return atendimentoRepository.findById(id).get();
	}
	
	@GetMapping(params = "id_reclamacao")
	public List<Atendimento> getAtendimentoByReclamacao (@RequestParam Integer id_reclamacao) {
		return atendimentoRepository.findByReclamacao(id_reclamacao);
	}
	
	@GetMapping(params = "status")
	public List<Atendimento> getAtendimentoByStatus (@RequestParam String status) {
		return atendimentoRepository.findByStatus(status);
	}
}
