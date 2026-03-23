package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.StatusEnum;
import br.com.ecommerce.transporte.model.Transportadora;

public class TransportadoraDAOimpl implements TransportadoraDAO{
    @Override
    public Entrega criarEntrega(int id, StatusEnum status, Double valorFrete, int prazoDias, int pedidoId, int transportadoraId, Transportadora transportadora) {
        String sql = "INSERTO INTO entrega (id, status, valorFrete, prazoDias, pedidoId, transportadoraId, transportadora) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Entrega entrega = Entrega.criarEntrega(id, status, valorFrete, prazoDias, pedidoId, transportadoraId, transportadora);
        transportadora.addEntregas(entrega);
        return entrega;
    }

    @Override
    public void escolherTransportadora(Transportadora transportadora) {

    }

    @Override
    public void atualizarStatus(StatusEnum statusEnum) {

    }

    @Override
    public void entregaRealizada(Entrega entrega) {
        Transportadora transportadora = entrega.getTransportadora();
        transportadora.removeEntregas(entrega);
    }
}
