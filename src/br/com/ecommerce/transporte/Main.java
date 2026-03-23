package br.com.ecommerce.transporte;

import br.com.ecommerce.transporte.dao.*;
import br.com.ecommerce.transporte.model.Entrega;
import br.com.ecommerce.transporte.model.Pedido;
import br.com.ecommerce.transporte.model.StatusEnum;
import br.com.ecommerce.transporte.model.Transportadora;
import br.com.ecommerce.transporte.service.EntregaService;
import br.com.ecommerce.transporte.util.ConnectionDB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionDB.getInstance().getConexao();
        System.out.println("Conexão obtida: " + connection);

        // DAO
        PedidoDAO pedidoDAO = new PedidoDAOimpl(connection);
        TransportadoraDAO transportadoraDAO = new TransportadoraDAOimpl(connection);

        // SERVICE
        EntregaService service = new EntregaService(connection);

        // 1. Criar Pedido
        Pedido pedido = new Pedido(2, 20.0, 100.0);
        pedidoDAO.salvar(pedido);

        // 2. Criar Transportadora
        Transportadora t1 = new Transportadora(2, "Sedex", 1.0, 200.0, 30.0, 7);
        transportadoraDAO.salvar(t1);

        // 3. Criar Entrega
        Entrega entrega = service.criarEntrega(pedido);

        System.out.println("Entrega criada:");
        System.out.println("ID: " + entrega.getId());
        System.out.println("Status: " + entrega.getStatus());

        // 4. Atualizar Status
        service.atualizarStatus(entrega.getId(), StatusEnum.PEDIDO_COLETADO);
        service.atualizarStatus(entrega.getId(), StatusEnum.EM_TRANSPORTE);
        service.atualizarStatus(entrega.getId(), StatusEnum.EM_ROTA_DE_ENTREGA);
        service.atualizarStatus(entrega.getId(), StatusEnum.ENTREGUE);

        System.out.println("Entrega finalizada.");
    }
}
