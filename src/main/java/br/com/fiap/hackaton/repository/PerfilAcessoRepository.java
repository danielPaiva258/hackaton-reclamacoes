package br.com.fiap.hackaton.repository;

import br.com.fiap.hackaton.models.PerfilAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfilAcessoRepository  extends JpaRepository<PerfilAcesso, Integer> {
    List<PerfilAcesso> findAllByCodigo(String codigo);

}
