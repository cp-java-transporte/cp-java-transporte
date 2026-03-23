package br.com.ecommerce.transporte.model;

public class Entrega {

    private int id;
    private StatusEnum status;
    private Double valorFrete;
    private int prazoDias;
    private int pedidoId;
    private int transportadoraId;
    private Transportadora transportadora;

    public Entrega(){}

    public Entrega(int id, StatusEnum status, Double valorFrete, int prazoDias, int pedidoId, int transportadoraId, Transportadora transportadora) {
        this.id = id;
        this.status = status;
        this.valorFrete = valorFrete;
        this.prazoDias = prazoDias;
        this.pedidoId = pedidoId;
        this.transportadoraId = transportadoraId;
        this.transportadora = transportadora;
    }

    public static Entrega criarEntrega(int id, StatusEnum status, Double valorFrete, int prazoDias, int pedidoId, int transportadoraId, Transportadora transportadora){
        return new Entrega(id, status, valorFrete, prazoDias, pedidoId, transportadoraId, transportadora);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
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

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }
}
