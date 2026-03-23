package br.com.ecommerce.transporte;

import br.com.ecommerce.transporte.dao.PedidoDAOimpl;
import br.com.ecommerce.transporte.dao.TransportadoraDAOimpl;
import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.Pedido;
import br.com.ecommerce.transporte.model.StatusEnum;
import br.com.ecommerce.transporte.model.Transportadora;
import br.com.ecommerce.transporte.util.ConnectionDB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectionDB connectionDB = ConnectionDB.getInstance();
        Connection connection = ConnectionDB.getInstance().getConexao();
        System.out.println("Conexão obtida: " + connection);


        //Entrega entrega = new Entrega(1, StatusEnum.AGUARDANDO_COLETA, 100.0, 5, 1, 1);
        //TransportadoraDAOimpl transportadora = new TransportadoraDAOimpl(connection);
        //transportadora.criarEntrega(entrega);

        //Pedido p1 = new Pedido(1, 10.0, 20.0);
        //PedidoDAOimpl pedido = new PedidoDAOimpl(connection);
        //pedido.salvar(p1);

        Transportadora t1 = new Transportadora(1, "Correio", 1.0, 100.0, 5.0, 7);
        TransportadoraDAOimpl transportadora = new TransportadoraDAOimpl(connection);
        transportadora.salvar(t1);
    }
}
