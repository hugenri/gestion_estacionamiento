package ClienteServidor;
//https://www.discoduroderoer.es/como-hacer-un-minichat-con-sockets-en-java/ 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Cliente2 implements Runnable {
 
    private int puerto;
    private String mensaje;
 
    public Cliente2(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
 
    @Override
    public void run() {
        //Host del servidor
        final String HOST = "127.0.0.1";
        //Puerto del servidor
        DataOutputStream out;
 
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, puerto);
 
            out = new DataOutputStream(sc.getOutputStream());
 
            //Envio un mensaje al cliente
            out.writeUTF(mensaje);
 
            sc.close();
 
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
}
