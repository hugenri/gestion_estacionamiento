/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frame1.java
 *
 * Created on 6/11/2020, 12:51:01 PM
 */
package Vista;

import ClienteServidor.Cliente;
import ClienteServidor.Cliente2;
import ClienteServidor.Servidor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author zero
 */
public class ClienteFrame extends javax.swing.JFrame implements Observer {

    /** Creates new form frame1 */
    public ClienteFrame() {
        initComponents();
         this.getRootPane().setDefaultButton(this.btnEnviar);
       
        Servidor s = new Servidor(5000);
   s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaNomina = new javax.swing.JTextArea();
        jBEnviarNomina = new javax.swing.JButton();
        jBCargarNomina = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cargar Nomina");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Area Chat"));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Area de nomina"));

        jTextAreaNomina.setColumns(20);
        jTextAreaNomina.setRows(5);
        jScrollPane3.setViewportView(jTextAreaNomina);

        jScrollPane1.setViewportView(jScrollPane3);

        jBEnviarNomina.setText("Enviar Nomina");
        jBEnviarNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarNominaActionPerformed(evt);
            }
        });

        jBCargarNomina.setText("Cargar Nomina");
        jBCargarNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargarNominaActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviar)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEnviarNomina)
                        .addGap(18, 18, 18)
                        .addComponent(jBCargarNomina)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar)
                    .addComponent(jBEnviarNomina)
                    .addComponent(jBCargarNomina)
                    .addComponent(jButton1))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
 String mensaje = "Contador: " + this.jTextField1.getText() + "\n";
 
        this.jTextArea1.append(mensaje);
         
        Cliente c = new Cliente(6000, mensaje);
        Thread t = new Thread(c);
        t.start();
          jTextField1.setText(null);
          
}//GEN-LAST:event_btnEnviarActionPerformed

private void jBEnviarNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarNominaActionPerformed
  
    
jTextArea1.setText(".");

    
    String mensaje = this.jTextAreaNomina.getText() + "\n";
 
        this.jTextAreaNomina.append(mensaje);
 
        Cliente2 c = new Cliente2(6000, mensaje);
        Thread t = new Thread(c);
        t.start();
}//GEN-LAST:event_jBEnviarNominaActionPerformed

private void jBCargarNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarNominaActionPerformed
 jTextAreaNomina.setText(leerArc()); 
}//GEN-LAST:event_jBCargarNominaActionPerformed
String leerArc() {
     String auxtex="";    // variable que almacena una linea de texto de archivo leído 
   String txt=""; // variable que almacenara el texto de archivo abierto 
    JFileChooser filechoo= new JFileChooser(); // se crea el objeto para seleccionar el archivo
    
    try 
   { 

     filechoo.showOpenDialog(null); // este metodo muestra la vetana
       
     File abrir = filechoo.getSelectedFile();   //se selecciona  el archivo 
     if(abrir != null) // si el archivo se diferente de null se lee
     {      
      FileReader archivo=new FileReader(abrir); // se crea el objeto para realizar la lectura del fichero de texto
      BufferedReader leer=new BufferedReader(archivo); //se crea el objeto que almacena en el búfer los caracteres del archivo
      while((auxtex=leer.readLine())!=null) // bucle para leer Linea a Linea el archivo
       { 
        txt += auxtex+ "\n"; // se guarda el contenido del archivo en la variable txt
       } 
 
        leer.close(); // se cierra el objeto  BufferedReader
     }     
    } 
    catch(IOException ex) // se captura el error si el archivo no existe
   { 
     JOptionPane.showMessageDialog(null,ex+"" + 
       "\nNo se ha encontrado el archivo","Aviso",JOptionPane.WARNING_MESSAGE); 
   } 
    return txt; // se retorna el contenido del archivo
  } 
   @Override
public void update(Observable o, Object arg) {
    this.jTextArea1.append((String) arg);
     this. jTextAreaNomina.append((String) arg);
}
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClienteFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton jBCargarNomina;
    private javax.swing.JButton jBEnviarNomina;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaNomina;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
