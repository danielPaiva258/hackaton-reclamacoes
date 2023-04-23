package br.com.fiap.hackaton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.hackaton.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>{

	@Query(value = "SELECT * FROM atendimento WHERE id_reclamacao = ?1", nativeQuery = true)
	public List<Atendimento> findByReclamacao(Integer id);

	@Query(value = "SELECT * FROM atendimento WHERE status = ?1", nativeQuery = true)
	public List<Atendimento> findByStatus(String status);
	
	@Query(value = "SELECT * FROM atendimento WHERE id_reclamacao = ?1", nativeQuery = true)
	public List<Atendimento> findHistoricoAtendimento(Integer id);
}
