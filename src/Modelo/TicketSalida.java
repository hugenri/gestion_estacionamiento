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
public class TicketSalida {
    
    private Timestamp  TiempoEntrada;


private int idEmpleado;
private int idCajon;
private String marca;
private int folio;
private int nivel;
private String placa;
private int cajon;

    public Timestamp getTiempoEntrada() {
        return TiempoEntrada;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getIdCajon() {
        return idCajon;
    }

    public String getMarca() {
        return marca;
    }

    public int getFolio() {
        return folio;
    }

    public int getNivel() {
        return nivel;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCajon() {
        return cajon;
    }

    public void setTiempoEntrada(Timestamp TiempoEntrada) {
        this.TiempoEntrada = TiempoEntrada;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setIdCajon(int idCajon) {
        this.idCajon = idCajon;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCajon(int cajon) {
        this.cajon = cajon;
    }
    
}
