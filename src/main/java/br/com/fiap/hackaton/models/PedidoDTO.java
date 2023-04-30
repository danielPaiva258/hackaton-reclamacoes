package br.com.fiap.hackaton.models;

public class PedidoDTO {

    private Integer id;

    public PedidoDTO(Integer id){
        setId(id);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}