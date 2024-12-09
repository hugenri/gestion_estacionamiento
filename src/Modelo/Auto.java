/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author zero
 */
public class Auto {
    private int id_auto;
    private String marca;
    private String modelo;
    private String placas;
    private String color;
    private String condicion;
   
    
    private int cajon;

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the placas
     */
    public String getPlacas() {
        return placas;
    }

    /**
     * @param placas the placas to set
     */
    public void setPlacas(String placas) {
        this.placas = placas;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the condicion
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * @param condicion the condicion to set
     */
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

   
    
    

    public int getCajon() {
        return cajon;
    }

    public void setCajon(int cajon) {
        this.cajon = cajon;
    }

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
