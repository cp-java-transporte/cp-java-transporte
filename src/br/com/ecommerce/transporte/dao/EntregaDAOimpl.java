package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EntregaDAOimpl implements EntregaDAO{

    private Connection conn;

    public EntregaDAOimpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public void salvar(Entrega entrega) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO entrega (id, status, valor_frete, prazo_dias, pedido_Id, transportadora_Id) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, entrega.getId());
            ps.setString(2, String.valueOf(entrega.getStatus()));
            ps.setDouble(3, entrega.getValorFrete());
            ps.setInt(4, entrega.getPrazoDias());
            ps.setInt(5, entrega.getPedidoId());
            ps.setInt(6, entrega.getTransportadoraId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPorId(int id) {
        return null;
    }

}
