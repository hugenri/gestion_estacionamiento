/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultasBD;

import Modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author zero
 */
public class EmpleadoQueries extends ConexionBD {
    
     public EmpleadoQueries() {
        super();
    }
     //Metodo para guardar un nuevo usuario
    public void registro(Empleado empleado) {

   
        
        try 
        {
            PreparedStatement ps = conector.prepareStatement("INSERT INTO empleado ( id_empleado,nombre,apellido,nivel,puesto,salario) VALUES (?,?,?,?,?,?)");
             
            ps.setInt(1, empleado.getIdEmpleado());
            ps.setString(2,  empleado.getNombre());
            ps.setString(3,  empleado.getApellido());
            ps.setInt(4,  empleado.getNivel());
             ps.setString(5,  empleado.getPuesto());
              ps.setInt(6,  empleado.getSalario());
              
            ps.executeUpdate();

           
        } catch (SQLException e) {
            System.out.println("error-->"+e);
        }
        
    }
    public List SalarioServicios(int salari, String f1, String f2)
    {
        
        List<Empleado> data = new ArrayList<Empleado>();

        try {
            PreparedStatement ps = conector.prepareStatement("select b.id_empleado, e.nombre, e.apellido, e.puesto, count(*) as 'servicios' from empleado e, boleto b where b.id_empleado=e.id_empleado AND b.entrada   group by e.nombre;");
            
          
          
           ResultSet rst = ps.executeQuery();
                int count=0;
                while (rst.next()) {
                    int salario = salari;
                    if(count++ < 5){
                        salario += salario * .10;
                    }
               Empleado em = new Empleado();

                em.setIdEmpleado(Integer.parseInt(rst.getString(1)));
                em.setNombre(rst.getString(2));
                em.setApellido(rst.getString(3));
                em.setPuesto(rst.getString(4));
                em.setTelefono(Integer.parseInt(rst.getString(5)));
                em.setSalario(salario);
               





                data.add(em);
            }
        } catch (SQLException e) {
            System.out.println("Error en sql: " + e);

        }
        return data;
    }

}
