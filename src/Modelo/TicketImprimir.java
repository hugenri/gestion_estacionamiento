/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.security.Timestamp;

/**
 *
 * @author zero
 */
public class TicketImprimir {
    private Timestamp  TiempoEntrada;
private Timestamp  tiempoSalida;
private int monto;
private int idEmpleado;
private int cajon;
private int nivel;
private int idBoleto;
private String placa;
private String modelo;
        private String marca;

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

    public int getCajon() {
        return cajon;
    }

    public int getNivel() {
        return nivel;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    

    public String getModelo() {
        return modelo;
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

    public void setCajon(int cajon) {
        this.cajon = cajon;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

   

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
