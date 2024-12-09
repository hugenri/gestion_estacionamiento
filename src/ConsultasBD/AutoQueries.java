/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultasBD;

import Modelo.Auto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author zero
 */
public class AutoQueries  extends ConexionBD {
 

    public AutoQueries() {
        super();
    }
    
  
    public void alta(Auto auto) {

        
        try {
                PreparedStatement ps = conector.prepareStatement("INSERT INTO auto ( marca,modelo,placa,color,observaciones) VALUES (?,?,?,?,?)");
             
            ps.setString(1, auto.getMarca());
            ps.setString(2, auto.getModelo());
            ps.setString(3, auto.getPlacas());
            ps.setString(4, auto.getColor());
            ps.setString(5, auto.getCondicion());
            ps.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println("Error en sql: "+ e);
            
        }
        
    }
}
