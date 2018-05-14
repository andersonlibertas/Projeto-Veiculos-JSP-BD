/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Anderson
 */
public class Conecta {

    private Connection conexao;

    public Conecta() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/veiculos";
            conexao = DriverManager.getConnection(url, "root", "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConexao() {
        return conexao;
    }
}
