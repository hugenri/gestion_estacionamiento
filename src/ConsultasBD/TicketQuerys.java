/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultasBD;

import Modelo.Ticket;
import Modelo.TicketImprimir;
import Modelo.TicketSalida;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zero
 */
public class TicketQuerys extends ConexionBD {
    
    public TicketQuerys(){
        super();
    }
     public int alta(Ticket ticket) {

        int result = 0;
        
        try {
                PreparedStatement ps = conector.prepareStatement("INSERT INTO boleto ( entrada, id_empleado, id_cajon, id_auto)"
                        + " VALUES (?,?,  LAST_INSERT_ID(), LAST_INSERT_ID())");
             
            ps.setTimestamp(1, ticket.getTiempoEntrada());
            ps.setInt(2, ticket.getIdEmpleado());
             
           
            ps.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println( e);
            
        }
        return result;
    }
     
 
     public List listar() {
        List<Ticket> datos = new ArrayList<Ticket>();
        try {
            
       PreparedStatement  ps = conector.prepareStatement("SELECT c.cajon, c.nivel, entrada, id_empleado,id_boleto "
               + "FROM boleto INNER JOIN cajones c ON boleto.id_cajon = c.id_cajon WHERE c.estado >=1;");
         ResultSet    rs = ps.executeQuery();
            while (rs.next()) {
               Ticket ticket= new Ticket();
                
                ticket.setIdCajon(Integer.parseInt(rs.getString(1)));
              ticket.setNivel(Integer.parseInt(rs.getString(2)));
             
               ticket.setTiempoEntrada(rs.getTimestamp(3));
               ticket.setIdEmpleado(Integer.parseInt(rs.getString(4)));
               ticket.setFolio(Integer.parseInt(rs.getString(5)));
               
                datos.add(ticket);
            }
        } catch (Exception e) {
            System.out.println("error-->"+e);
        }
        return datos;
    }
         public void  ImprimirBoleto() {
       TicketImprimir ti = new  TicketImprimir();
        try {
            
       PreparedStatement  ps = conector.prepareStatement("SELECT c.cajon, c.nivel, a.marca, a.placa, id_empleado FROM boleto, cajones c, auto a WHERE boleto.id_boleto= 1 and boleto.id_auto = a.id_auto and c.id_cajon =boleto.id_auto ;");
         ResultSet    rs = ps.executeQuery();
            while (rs.next()) {
           
               
               
                ti.setCajon(Integer.parseInt(rs.getString(1)));
              ti.setNivel(Integer.parseInt(rs.getString(2)));
                ti.setMarca(rs.getString(3));
                ti.setPlaca(rs.getString(4));
               
                
             
              
               ti.setIdEmpleado(Integer.parseInt(rs.getString(5)));
               
                
            }
        } catch (Exception e) {
            System.out.println("error-->"+e);
        }
        
    }
         public List ticketsalisada(int f) {
        List<TicketSalida> datos = new ArrayList<TicketSalida>();
int folio = f;
       try {
            PreparedStatement ps = conector.prepareStatement("SELECT  c.cajon, c.nivel, entrada, a.marca, a.placa FROM boleto, cajones c, auto a WHERE boleto.Id_boleto =? and boleto.id_auto = a.id_auto and c.id_cajon =boleto.id_auto ");
             ps.setInt(1,folio);
         ResultSet    rs = ps.executeQuery();
            while (rs.next()) {
               TicketSalida ticket= new TicketSalida();
                
                ticket.setCajon(Integer.parseInt(rs.getString(1)));
              ticket.setNivel(Integer.parseInt(rs.getString(2)));
             
               ticket.setTiempoEntrada(rs.getTimestamp(3));
               ticket.setMarca(rs.getString(4));
               ticket.setPlaca(rs.getString(5));
               
                datos.add(ticket);
            }
        } catch (Exception e) {
            System.out.println("Error..."+e);
        }
        return datos;
    }
    }
    

     


