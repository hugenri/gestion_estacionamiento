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
public class VerCajon {
    private Timestamp  TiempoEntrada;
     private String marca;
    
    private String placa;
    private int idEmpleado;  
    private int  id_cajon;
private int nivel;
private int cajon;
private int estado;

    public Timestamp getTiempoEntrada() {
        return TiempoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getId_cajon() {
        return id_cajon;
    }

    public int getNivel() {
        return nivel;
    }

    public int getCajon() {
        return cajon;
    }

    public int getEstado() {
        return estado;
    }

    public void setTiempoEntrada(Timestamp TiempoEntrada) {
        this.TiempoEntrada = TiempoEntrada;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setId_cajon(int id_cajon) {
        this.id_cajon = id_cajon;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setCajon(int cajon) {
        this.cajon = cajon;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    

    
}
