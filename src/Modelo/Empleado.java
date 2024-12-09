/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author zero
 */
public class Empleado {
private int idEmpleado;    
private String nombre;
private String apellido;
private String puesto;
private int telefono;
private int salario;
private int nivel;


public int getIdEmpleado() {
        return idEmpleado;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getSalario() {
        return salario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
}
