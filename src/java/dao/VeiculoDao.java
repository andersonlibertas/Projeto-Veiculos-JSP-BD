/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Veiculo;
import conexao.Conecta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Anderson
 */
public class VeiculoDao {

    public boolean inserir(Veiculo v) {

        try {
            //Instância da classe Conecta - Conectando ao banco de dados
            Conecta con = new Conecta();

            //Query sql sendo inserida dentro de uma String
            String sql = "INSERT INTO dados (marca, placa, modelo, ano)"
                    + " VALUES (?, ?, ?, ?)";

            //Pega os valores armazenados dos objetos e passa para executar posteriormente
            //Pegando a conexão e declarando a query
            PreparedStatement p = con.getConexao().prepareStatement(sql);
            //Pega os valores armazenados dos objetos e passa para executar posteriormente
            p.setString(1, v.getMarca());
            p.setString(2, v.getPlaca());
            p.setString(3, v.getModelo());
            p.setInt(4, v.getAno());
            //Executa a declaração
            p.execute();
            //fecha conexão
            p.close();
            con.getConexao().close();
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    public boolean excluir(Veiculo p) {
        try {
            Conecta con = new Conecta();
            String sql = "DELETE FROM dados "
                    + "WHERE idveiculo = ?";
            //prepara instrução para ser executada
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            //passa os parâmetros para a instrução ???
            prep.setInt(1, p.getIdveiculo());
            // executa instrução
            prep.execute();
            //fecha conexão
            prep.close();
            con.getConexao().close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Veiculo v) {

        try {
            //Instância da classe Conecta - Conectando ao banco de dados
            Conecta con = new Conecta();

            //Query sql sendo inserida dentro de uma String
            String sql = "UPDATE dados SET marca = ?, placa = ?, modelo = ?, ano = ? WHERE idveiculo = ?";

            //Pega os valores armazenados dos objetos e passa para executar posteriormente
            //Pegando a conexão e declarando a query
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            //Pega os valores armazenados dos objetos e passa para executar posteriormente
            prep.setString(1, v.getMarca());
            prep.setString(2, v.getPlaca());
            prep.setString(3, v.getModelo());
            prep.setInt(4, v.getAno());
            prep.setInt(5, v.getIdveiculo());
            //Executa a declaração
            prep.execute();
            //fecha conexão
            prep.close();
            con.getConexao().close();
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    public ArrayList<Veiculo> listar() {
        ArrayList<Veiculo> lista = new ArrayList<Veiculo>();

        try {
            //conectar ao banco
            Conecta con = new Conecta();
            //instrução de consulta
            String sql = "SELECT idveiculo, marca, placa, modelo, ano "
                    + "FROM dados ORDER BY marca";
            Statement instrucao = con.getConexao().createStatement();
            ResultSet res = instrucao.executeQuery(sql);
            //percorre o resultado
            while (res.next()) {
                Veiculo p = new Veiculo();
                p.setIdveiculo(res.getInt("idveiculo"));
                p.setMarca(res.getString("marca"));
                p.setPlaca(res.getString("placa"));
                p.setModelo(res.getString("modelo"));
                p.setAno(res.getInt("ano"));

                lista.add(p);
            }
            //fecha conexão
            res.close();
            con.getConexao().close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void consultar(Veiculo v) {
//        Veiculo p = new Veiculo();

        try {
            //abre conexão com banco de dados
            Conecta con = new Conecta();
            //Faz a consulta
            String sql = "SELECT idveiculo, marca, placa, modelo, ano"
                    + " FROM dados WHERE idveiculo = " + v.getIdveiculo();
            Statement instrucao = con.getConexao().createStatement();
            ResultSet res = instrucao.executeQuery(sql);
            //percorre o resultado da consulta
            if (res.next()) {
                //atribuo os valores do banco de dados no objeto p
                v.setIdveiculo(res.getInt("idveiculo"));
                v.setMarca(res.getString("marca"));
                v.setPlaca(res.getString("placa"));
                v.setModelo(res.getString("modelo"));
                v.setAno(res.getInt("ano"));

            }
            //fecha resultado e conexão com banco
            res.close();
            con.getConexao().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean inserirOuAlterar(Veiculo v) {
        if (v.getIdveiculo() > 0) {
            return alterar(v);
        } else {
            return inserir(v);

        }

    }
    


//    public ArrayList<String> selecta() {
//        return vv;
//    }
}
