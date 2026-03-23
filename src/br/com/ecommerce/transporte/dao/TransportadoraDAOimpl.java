package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.Pedido;
import br.com.ecommerce.transporte.model.StatusEnum;
import br.com.ecommerce.transporte.model.Transportadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransportadoraDAOimpl implements TransportadoraDAO{

    private Connection conn;

    public TransportadoraDAOimpl(Connection connection){
        this.conn = connection;
    }

    @Override
    public void salvar(Transportadora transportadora) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO transportadora (id, nome, peso_min, peso_max, valor_base, prazo_dias) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, transportadora.getId());
            ps.setString(2, transportadora.getNome());
            ps.setDouble(3, transportadora.getPesoMin());
            ps.setDouble(4, transportadora.getPesoMax());
            ps.setDouble(5, transportadora.getValorBase());
            ps.setInt(6, transportadora.getPrazoDias());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPorId(int id) {
        return null;
    }

    @Override
    public void criarEntrega(Entrega entrega) {
        String sql = "INSERT INTO entrega (id, status, valorFrete, prazoDias, pedidoId, transportadoraId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, entrega.getId());
            statement.setString(2, String.valueOf(entrega.getStatus()));
            statement.setDouble(3, entrega.getValorFrete());
            statement.setInt(4, entrega.getPrazoDias());
            statement.setInt(5, entrega.getPedidoId());
            statement.setInt(6, entrega.getTransportadoraId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar entrega -> " + e);
        }
    }

    @Override
    public void escolherTransportadora(Transportadora transportadora) {

    }

    @Override
    public void atualizarStatus(StatusEnum statusEnum) {

    }

    @Override
    public void entregaRealizada(Entrega entrega) {

    }
}
