package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Pedido;

import java.util.List;

public interface EntregaDAO {
    void salvar(Pedido pedido);
    Pedido buscarPorId(int id);
    List<Pedido> listarTodos();
}
