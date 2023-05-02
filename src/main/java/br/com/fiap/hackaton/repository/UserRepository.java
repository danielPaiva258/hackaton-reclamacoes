package br.com.fiap.hackaton.repository;

import br.com.fiap.hackaton.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.perfisAcesso WHERE u.username = :username")
    Optional<Usuario> findFirstByUsername(String username);

}
