package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.StatusEnum;
import br.com.ecommerce.transporte.model.Transportadora;

public interface TransportadoraDAO {
    public Entrega criarEntrega(int id, StatusEnum status, Double valorFrete, int prazoDias, int pedidoId, int transportadoraId, Transportadora transportadora);
    public void escolherTransportadora(Transportadora transportadora);
    public void atualizarStatus(StatusEnum statusEnum);
    public void entregaRealizada(Entrega entrega);

}
