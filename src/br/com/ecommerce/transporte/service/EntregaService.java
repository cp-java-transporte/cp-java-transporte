package br.com.ecommerce.transporte.service;

import br.com.ecommerce.transporte.dao.EntregaDAO;
import br.com.ecommerce.transporte.dao.EntregaDAOimpl;
import br.com.ecommerce.transporte.dao.TransportadoraDAO;
import br.com.ecommerce.transporte.dao.TransportadoraDAOimpl;
import br.com.ecommerce.transporte.exception.PedidoException;
import br.com.ecommerce.transporte.exception.TransportadoraException;
import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.Pedido;
import br.com.ecommerce.transporte.model.StatusEnum;
import br.com.ecommerce.transporte.model.Transportadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EntregaService {
    private EntregaDAO entregaDAO;
    private TransportadoraDAO transportadoraDAO;

    public EntregaService(Connection conn) {
        this.entregaDAO = new EntregaDAOimpl(conn);
        this.transportadoraDAO = new TransportadoraDAOimpl(conn);
    }

    public Transportadora escolherTransportadora(double peso) {
        List<Transportadora> lista = transportadoraDAO.listarTodas();

        for (Transportadora t : lista) {
            if (peso >= t.getPesoMin() && peso <= t.getPesoMax()) {
                return t;
            }
        }

        throw new TransportadoraException("Nenhuma transportadora atende o peso");
    }

    public Entrega criarEntrega(Pedido pedido) {

        Transportadora t = escolherTransportadora(pedido.getPeso());

        Entrega entrega = new Entrega();
        entrega.setId((int)(Math.random() * 1000));
        entrega.setPedidoId(pedido.getId());
        entrega.setTransportadoraId(t.getId());
        entrega.setStatus(StatusEnum.AGUARDANDO_COLETA);
        entrega.setValorFrete(t.getValorBase());
        entrega.setPrazoDias(t.getPrazoDias());

        entregaDAO.salvar(entrega);

        return entrega;
    }

    public void atualizarStatus(int entregaId, StatusEnum status) {
        entregaDAO.atualizarStatus(entregaId, status.name());
    }
}
