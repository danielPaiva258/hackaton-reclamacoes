package br.com.fiap.hackaton.repositories;

import java.util.List;

import br.com.fiap.hackaton.models.AtendimentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.hackaton.models.Reclamacao;

public interface ReclamacaoRepository extends JpaRepository<Reclamacao, Integer>{

	@Query(value = "SELECT * FROM reclamacao WHERE id_cliente = ?1", nativeQuery = true)
	public List<Reclamacao> findByCliente(Integer id_cliente);

	@Query(value = "SELECT * FROM reclamacao WHERE status != 'Fechada' ORDER BY data_criacao ASC", nativeQuery = true)
	public List<Reclamacao> findAllAtivas();

	@Query(value = "SELECT id FROM atendimento WHERE id_reclamacao = ?1", nativeQuery = true)
	public List<Integer> findHistoricoAtendimento(Integer idReclamacao);

}
