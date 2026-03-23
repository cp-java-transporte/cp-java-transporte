package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.StatusEnum;
import br.com.ecommerce.transporte.model.Transportadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransportadoraDAOimpl implements TransportadoraDAO{

    private Connection connection;

    public TransportadoraDAOimpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void criarEntrega(Entrega entrega) {
        String sql = "INSERTO INTO entrega (id, status, valorFrete, prazoDias, pedidoId, transportadoraId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(2, String.valueOf(entrega.getStatus()));
            statement.setDouble(3, entrega.getValorFrete());
            statement.setInt(4, entrega.getPrazoDias());
            statement.setInt(5, entrega.getTransportadoraId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
