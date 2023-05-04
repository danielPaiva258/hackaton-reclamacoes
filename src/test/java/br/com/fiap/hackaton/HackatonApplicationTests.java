package br.com.fiap.hackaton;

import br.com.fiap.hackaton.models.Usuario;
import br.com.fiap.hackaton.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HackatonApplicationTests {

	@Autowired
	private UserRepository userRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void recupera_usuario_por_nome() {
		String nome = "cliente";
		Usuario usuario = userRepository.findFirstByUsername(nome)
				.orElseThrow();
		Integer id = 4;
		String password = "$2a$10$ehbYL0UV4xOyslw91Gq06.0UjfKaLRr22tYOFBMto7tpJ8rZjI3f.";
		Date dt_desativado = null;


		assertEquals(id, usuario.getId());
		assertEquals(nome, usuario.getUsername());
		assertEquals(password, usuario.getPassword());
		assertEquals(dt_desativado, usuario.getDtDesativado());

	}


}
