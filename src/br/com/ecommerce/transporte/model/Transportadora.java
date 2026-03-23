package br.com.ecommerce.transporte.model;

import java.util.ArrayList;
import java.util.List;

public class Transportadora {

    private int id;
    private String nome;
    private Double pesoMin;
    private Double pesoMax;
    private Double valorBase;
    private int prazoDias;
    private List<Entrega> entregas = new ArrayList<>();

    public Transportadora(){}

    public Transportadora(int id, String nome, Double pesoMin, Double pesoMax, Double valorBase, int prazoDias) {
        this.id = id;
        this.nome = nome;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
        this.valorBase = valorBase;
        this.prazoDias = prazoDias;
    }

    public Entrega criarEntrega(int id, StatusEnum status, Double valorFrete, int prazoDias, int pedidoId, int transportadoraId, Transportadora transportadora){
        Entrega entrega = Entrega.criarEntrega(id, status, valorFrete, prazoDias, pedidoId, transportadoraId, transportadora);
        entregas.add(entrega);
        return entrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(Double pesoMin) {
        this.pesoMin = pesoMin;
    }

    public Double getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(Double pesoMax) {
        this.pesoMax = pesoMax;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    public void setPrazoDias(int prazoDias) {
        this.prazoDias = prazoDias;
    }
}
