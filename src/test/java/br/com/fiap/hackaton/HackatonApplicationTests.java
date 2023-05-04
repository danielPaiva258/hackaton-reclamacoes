package br.com.fiap.hackaton;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.fiap.hackaton.models.Pedido;
import br.com.fiap.hackaton.repositories.PedidoRepository;

@SpringBootTest
@ActiveProfiles("test")
class HackatonApplicationTests {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void recupera_pedido_por_id() {
        Integer idPedido = 1;
        Pedido pedido = pedidoRepository.findById(idPedido).get();

        String nrPedido = "00001";
        Integer idCliente = 1;
        String data = "2023-04-20";

        assertEquals(nrPedido, pedido.getNumero_pedido());
        assertEquals(idCliente, pedido.getId_cliente());
        assertEquals(data, pedido.getData());


    }

}