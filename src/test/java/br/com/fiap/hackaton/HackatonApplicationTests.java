package br.com.fiap.hackaton;

import br.com.fiap.hackaton.models.Cliente;
import br.com.fiap.hackaton.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HackatonApplicationTests {

	@Autowired
	private ClienteRepository clienteRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void recupera_informacoes_de_clientes_por_id() {
		Integer id = 1;
		Cliente cli = clienteRepository.findById(id).get();
		String cliName = "João da Silva";
		assertEquals(cliName, cli.getNome());
	}

	@Test
	void recupera_informacoes_de_clientes_por_nome() {
		Integer id = 1;
		String cliName = "João da Silva";
		List<Cliente> clients = clienteRepository.findAllByNome(cliName);
		assertEquals(clients.size(), 1);
		assertEquals(clients.get(0).getId(), 1);
	}

}
