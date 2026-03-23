package br.com.ecommerce.transporte.model;

public class Pedido {

    private int id;
    private Double peso;
    private Double valor;

    public Pedido(){}

    public Pedido(int id, Double peso, Double valor) {
        this.id = id;
        this.peso = peso;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
