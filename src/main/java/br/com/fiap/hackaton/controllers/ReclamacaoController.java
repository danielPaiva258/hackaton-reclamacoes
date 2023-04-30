package br.com.fiap.hackaton.controllers;

import br.com.fiap.hackaton.models.AtendimentoDTO;
import br.com.fiap.hackaton.models.Reclamacao;
import br.com.fiap.hackaton.repositories.ReclamacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/reclamacao")
@CrossOrigin(maxAge = 3600)
public class ReclamacaoController {

	@Autowired
	private ReclamacaoRepository reclamacaoRepository;
	
	@GetMapping("/ativas")
	public List<Reclamacao> getReclamacoesAtivas () {

		return incluirAtendimentos(reclamacaoRepository.findAllAtivas());
	}
	
	@GetMapping("/list")
	public List<Reclamacao> getReclamacoes () {
		return incluirAtendimentos(reclamacaoRepository.findAll(Sort.by(Sort.Direction.ASC, "dataCriacao")));
	}
	
	@GetMapping("/{id}")
	public Reclamacao getReclamacaoById (@PathVariable Integer id) {
		return incluirAtendimentos(reclamacaoRepository.findById(id).get());
	}
	
	@GetMapping(params = "id_cliente")
	public List<Reclamacao> getReclamacaoByCliente (@RequestParam Integer id_cliente) {
		return incluirAtendimentos(reclamacaoRepository.findByCliente(id_cliente));
	}
	
	@GetMapping("{id}/historico_atendimento")
	public List<Integer> getHistoricoAtendimento (@PathVariable Integer idReclamacao) {
		return reclamacaoRepository.findHistoricoAtendimento(idReclamacao);
	}

	////////////////////////////////////
	private List<Reclamacao> incluirAtendimentos(List<Reclamacao> reclamacoes){
		for (Reclamacao reclamacao : reclamacoes){
			reclamacao.setHistorico_atendimento(reclamacaoRepository.findHistoricoAtendimento(reclamacao.getId())
					.stream().map(idAtendimento -> new AtendimentoDTO(idAtendimento)).toList());
		}
		return reclamacoes;
	}
	private Reclamacao incluirAtendimentos(Reclamacao reclamacao){
		reclamacao.setHistorico_atendimento(reclamacaoRepository.findHistoricoAtendimento(reclamacao.getId())
				.stream().map(idAtendimento -> new AtendimentoDTO(idAtendimento)).toList());
		return reclamacao;
	}
}
