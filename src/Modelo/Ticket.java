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
public class Ticket {
private Timestamp  TiempoEntrada;
private Timestamp  tiempoSalida;
private int monto;
private int idEmpleado;
private int idCajon;
private int idAuto;
private int folio;
private int nivel;
private String HoraSalida;

    public Timestamp getTiempoEntrada() {
        return TiempoEntrada;
    }

    public Timestamp getTiempoSalida() {
        return tiempoSalida;
    }

    public int getMonto() {
        return monto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getIdCajon() {
        return idCajon;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setTiempoEntrada(Timestamp TiempoEntrada) {
        this.TiempoEntrada = TiempoEntrada;
    }

    public void setTiempoSalida(Timestamp tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setIdCajon(int idCajon) {
        this.idCajon = idCajon;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public int getFolio() {
        return folio;
    }

    public int getNivel() {
        return nivel;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }
    
}



