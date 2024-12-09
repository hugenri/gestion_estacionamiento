/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import ConsultasBD.TicketQuerys;
import Modelo.Ticket;
import Vista.AutosActivos;
import Vista.AutosActivos2;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloAutosActivos implements Runnable{
    
   
    
    
    @Override
    public void run()
    {
        
        TicketQuerys tq = new TicketQuerys();
         List<Ticket> lista = tq.listar();
         AutosActivos cajonFrame = new AutosActivos(lista);//se abre la ventana que muestra los cajones
            cajonFrame.setVisible(true);
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloAutosActivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
