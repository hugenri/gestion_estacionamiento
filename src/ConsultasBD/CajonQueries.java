/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultasBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Cajon;
import Modelo.VerCajon;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hugo
 */
public class CajonQueries extends ConexionBD {

    public CajonQueries() {
        super();
    }

    public int alta(Cajon cajon) {

        int result = 0;

        try {
            PreparedStatement ps = conector.prepareStatement("INSERT INTO cajones ( nivel, cajon, estado) VALUES (?,?,?)");

            ps.setInt(1, cajon.getNivel());
            ps.setInt(2, cajon.getCajon());
            ps.setInt(3, cajon.getEstado());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        }
        return result;
    }

    public void BajaCajon(int idCajon) {

        try {
            PreparedStatement ps = conector.prepareStatement("UPDATE cajones SET estado= 0 WHERE id_cajon=? ");

            
            ps.setInt(1, idCajon);

            ps.executeUpdate();
           ps.close();
        } catch (SQLException e) {
            System.out.println("Error --->"+e);

        }


    }

    public List VerCaj(int folio) {
        List<VerCajon> data = new ArrayList<VerCajon>();
int f = folio;
        try {
            PreparedStatement ps = conector.prepareStatement("SELECT c.id_cajon, c.cajon, c.nivel,c.estado, entrada, id_empleado,a.marca, a.placa FROM boleto, cajones c, auto a WHERE boleto.Id_boleto =? and boleto.id_auto = a.id_auto and c.id_cajon =boleto.id_auto ");
             ps.setInt(1,f);
            ResultSet rs = ps.executeQuery();
          
            while (rs.next()) {
                VerCajon Vc = new VerCajon();

                Vc.setId_cajon(Integer.parseInt(rs.getString(1)));
                Vc.setCajon(Integer.parseInt(rs.getString(2)));
                Vc.setNivel(Integer.parseInt(rs.getString(3)));
                Vc.setEstado(Integer.parseInt(rs.getString(4)));
                Vc.setTiempoEntrada(rs.getTimestamp(5));

                Vc.setIdEmpleado(Integer.parseInt(rs.getString(6)));




                Vc.setMarca(rs.getString(7));
                Vc.setPlaca(rs.getString(8));

                data.add(Vc);
            }
        } catch (SQLException e) {
            System.out.println("Error en sql: " + e);

        }
        return data;
    }
}
