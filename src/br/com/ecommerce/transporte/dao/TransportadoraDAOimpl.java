package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.exception.TransportadoraException;
import br.com.ecommerce.transporte.model.Transportadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public Transportadora buscarPorId(int id) {
        String sql = "SELECT * FROM transportadora WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Transportadora(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("peso_min"),
                        rs.getDouble("peso_max"),
                        rs.getDouble("valor_base"),
                        rs.getInt("prazo_dias")
                );
            }

        } catch (SQLException e) {
            throw new TransportadoraException("Erro ao buscar transportadora" + e);
        }

        return null;
    }

    @Override
    public List<Transportadora> listarTodas() {
        String sql = "SELECT * FROM transportadora";
        List<Transportadora> lista = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Transportadora(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("peso_min"),
                        rs.getDouble("peso_max"),
                        rs.getDouble("valor_base"),
                        rs.getInt("prazo_dias")
                ));
            }

        } catch (SQLException e) {
            throw new TransportadoraException("Erro ao listar transportadoras" + e);
        }

        return lista;
    }
}
