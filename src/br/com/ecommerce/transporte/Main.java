package br.com.ecommerce.transporte;

import br.com.ecommerce.transporte.util.ConnectionDB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConnectionDB connectionDB = ConnectionDB.getInstance();
        Connection connection = ConnectionDB.getInstance().getConexao();
        System.out.println("Conexão obtida: " + connection);
    }
}
