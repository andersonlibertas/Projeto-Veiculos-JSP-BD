/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Anderson
 */
public class Marca {
    private int idmarca;
    private String marca;

    public Marca() {
    }

    public String getMarca() {
        return marca;
    }
 
    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }



}
