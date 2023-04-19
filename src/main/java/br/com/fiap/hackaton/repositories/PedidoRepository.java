package br.com.fiap.hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hackaton.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
