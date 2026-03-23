package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EntregaDAOimpl implements EntregaDAO{

    private Connection conn;

    @Override
    public void salvar(Pedido pedido) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO entrga (id, status, valorFrete, prazoDias, pedidoId, transportadoraId) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, pedido.getId());
            ps.setDouble(2, pedido.getPeso());
            ps.setDouble(3, pedido.getValor());
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
    public List<Pedido> listarTodos() {
        return List.of();
    }
}
