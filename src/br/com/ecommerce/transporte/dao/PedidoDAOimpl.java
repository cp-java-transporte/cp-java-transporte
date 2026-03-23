package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.exception.PedidoException;
import br.com.ecommerce.transporte.model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PedidoDAOimpl implements PedidoDAO{

    private Connection conn;

    public PedidoDAOimpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void salvar(Pedido pedido) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO pedido (id, peso, valor) VALUES (?, ?, ?)");
            ps.setInt(1, pedido.getId());
            ps.setDouble(2, pedido.getPeso());
            ps.setDouble(3, pedido.getValor());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PedidoException("Erro ao salvar pedido " + e);
        }
    }

    @Override
    public Pedido buscarPorId(int id) {
        String sql = "SELECT * FROM pedido WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Pedido(
                        rs.getInt("id"),
                        rs.getDouble("peso"),
                        rs.getDouble("valor")
                );
            }

        } catch (SQLException e) {
            throw new PedidoException("Erro ao buscar pedido " + e);
        }
        return null;
    }

}
