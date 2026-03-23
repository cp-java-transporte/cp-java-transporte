package br.com.ecommerce.transporte.dao;

import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.Pedido;
import br.com.ecommerce.transporte.model.StatusEnum;
import br.com.ecommerce.transporte.model.Transportadora;

import java.util.List;

public interface TransportadoraDAO {
    void salvar(Transportadora transportadora);
    Pedido buscarPorId(int id);


}
