package br.com.fiap.hackaton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Atendimento;
import br.com.fiap.hackaton.models.Reclamacao;
import br.com.fiap.hackaton.repositories.AtendimentoRepository;
import br.com.fiap.hackaton.repositories.ReclamacaoRepository;

@RestController()
@RequestMapping(path = "/reclamacao")
@CrossOrigin(maxAge = 3600)
public class ReclamacaoController {

	@Autowired
	private ReclamacaoRepository reclamacaoRepository;
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@GetMapping("/ativas")
	public List<Reclamacao> getReclamacoesAtivas () {
		return reclamacaoRepository.findAllAtivas();
	}
	
	@GetMapping("/list")
	public List<Reclamacao> getReclamacoes () {
		return reclamacaoRepository.findAll(Sort.by(Sort.Direction.ASC, "dataCriacao"));
	}
	
	@GetMapping("/{id}")
	public Reclamacao getReclamacaoById (@PathVariable Integer id) {
		return reclamacaoRepository.findById(id).get();
	}
	
	@GetMapping(params = "id_cliente")
	public List<Reclamacao> getReclamacaoByCliente (@RequestParam Integer id_cliente) {
		return reclamacaoRepository.findByCliente(id_cliente);
	}
	
	@GetMapping("{id}/historico_atendimento")
	public List<Atendimento> getHistoricoReclamacao (@PathVariable Integer id) {
		return atendimentoRepository.findHistoricoAtendimento(id);
	}
}
