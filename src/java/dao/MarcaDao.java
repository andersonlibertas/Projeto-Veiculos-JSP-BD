/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Marca;
import bean.Veiculo;
import conexao.Conecta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Anderson
 */
public class MarcaDao {

    public ArrayList<Marca> listar() {
        ArrayList<Marca> lista = new ArrayList<Marca>();

        try {
            //conectar ao banco
            Conecta con = new Conecta();
            //instrução de consulta
            String sql = "SELECT idmarca, marca"
                    + "FROM marcas ORDER BY marca";
            Statement instrucao = con.getConexao().createStatement();
            ResultSet res = instrucao.executeQuery(sql);
            //percorre o resultado
            while (res.next()) {
                Marca p = new Marca();
                p.setIdmarca(res.getInt("idmarca"));
                p.setMarca(res.getString("marca"));


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
     public void consultar(Marca v) {
//        Veiculo p = new Veiculo();

        try {
            //abre conexão com banco de dados
            Conecta con = new Conecta();
            //Faz a consulta
            String sql = "SELECT idmarca, marca"
                    + " FROM marcas WHERE idmarca = " + v.getIdmarca();
            Statement instrucao = con.getConexao().createStatement();
            ResultSet res = instrucao.executeQuery(sql);
            //percorre o resultado da consulta
            if (res.next()) {
                //atribuo os valores do banco de dados no objeto p
                v.setIdmarca(res.getInt("idmarca"));
                v.setMarca(res.getString("marca"));
                

            }
            //fecha resultado e conexão com banco
            res.close();
            con.getConexao().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
