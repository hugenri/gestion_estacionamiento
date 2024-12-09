/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author zero
 */
public class Cajon {
private int  id_cajon;
private int nivel;
private int cajon;
private int estado;

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
