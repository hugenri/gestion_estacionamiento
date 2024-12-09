/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultasBD;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conex {
private static String base="buenasManos"; // se crea la variable que almacena el nombre de la base de datos
private static String usuario="root"; // se crean las variables que almacenan el nombre de usuario y la clave
private static String clave="hugo";
/*donde jdbc es la API, mysql es el  gestor de base de datos, localhost
 * es el nombre del servidor en el que se ejecuta mysql, también podemos
 * usar la dirección IP, 3306 es el número de puerto y bese es el nombre
 * de la base de datos*/
private static String url="jdbc:mysql://localhost:3306/buenasManos?serverTimezone=CST6CDT";
private static Connection conector;

public static Connection getConnection(){
    try{
        
        conector=DriverManager.getConnection(url, usuario, clave);//se utiliza para establecer la conexión con la url, el nombre de usuario y la contraseña especificados.

}catch(Exception e){
    JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
}
    return conector;
}


}