/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import ConsultasBD.CajonQueries;

/**
 *
 * @author zero
 */
public class ThreadBajaAuto implements Runnable{
    int id;
    public  ThreadBajaAuto(int id)
    {
        this.id = id;
    }
    @Override
    public void run() 
    {
        CajonQueries cq = new CajonQueries();
        cq.BajaCajon(id);
        
    }
}
