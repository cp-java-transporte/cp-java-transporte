package br.com.ecommerce.transporte.model;

public class Entrega {

    private int id;
    private StatusEnum status;
    private Double valorFrete;
    private int prazoDias;
    private int pedidoId;
    private int transportadoraId;

    public Entrega(){}

    public Entrega(int id, StatusEnum status, Double valorFrete, int prazoDias, int pedidoId, int transportadoraId) {
        this.id = id;
        this.status = status;
        this.valorFrete = valorFrete;
        this.prazoDias = prazoDias;
        this.pedidoId = pedidoId;
        this.transportadoraId = transportadoraId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    public void setPrazoDias(int prazoDias) {
        this.prazoDias = prazoDias;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getTransportadoraId() {
        return transportadoraId;
    }

    public void setTransportadoraId(int transportadoraId) {
        this.transportadoraId = transportadoraId;
    }

}
