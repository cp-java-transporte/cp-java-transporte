package br.com.ecommerce.transporte.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection conexao;
    private static ConnectionDB instancia;

    private ConnectionDB(){
        try{
            String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
            String USER = "rm560340";
            String PASSWORD = "200206";
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ConnectionDB getInstance() {
        if (instancia==null){
            instancia = new ConnectionDB();
        }
        return instancia;
    }

    public Connection getConexao(){
        return conexao;
    }
}
