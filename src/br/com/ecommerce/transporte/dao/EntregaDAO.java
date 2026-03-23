package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.Pedido;

import java.util.List;

public interface EntregaDAO {
    void salvar(Entrega entrega);
    Entrega buscarPorId(int id);
    void atualizarStatus(int id, String status);
}
