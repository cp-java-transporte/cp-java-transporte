package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.Pedido;
import br.com.ecommerce.transporte.model.StatusEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Entrega buscarPorId(int id) {
        String sql = "SELECT * FROM entrega WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Entrega(
                        rs.getInt("id"),
                        StatusEnum.valueOf(rs.getString("status")),
                        rs.getDouble("valor_frete"),
                        rs.getInt("prazo_dias"),
                        rs.getInt("pedido_id"),
                        rs.getInt("transportadora_id")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar entrega", e);
        }

        return null;
    }

    @Override
    public void atualizarStatus(int id, String status) {
        String sql = "UPDATE entrega SET status = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar status", e);
        }
    }

}
