package br.com.fiap.hackaton.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.hackaton.models.Reclamacao;

@RestController("/reclamacao")
public class ReclamacaoController {

	@GetMapping("/list")
	public List<Reclamacao> getReclamacao () {
		return new ArrayList<>();
	}
}
