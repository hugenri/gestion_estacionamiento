/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AutosActivos.java
 *
 * Created on 20/10/2020, 03:30:22 PM
 */
package Vista;

import Vista.*;
import Modelo.Ticket;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ConsultasBD.TicketQuerys;
import Hilos.HiloAutosActivos;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author zero
 */
public class AutosActivos2 extends javax.swing.JFrame {
 DefaultTableModel modelo = new DefaultTableModel();
 
    private final List<Ticket> autos;
    public AutosActivos2(List<Ticket> autos) {
        this.autos = autos;
        initComponents();
       VerCajones();
    }

    private AutosActivos2() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(-16776961,true));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista Cajones Ocupados", 0, 0, null, new java.awt.Color(-1,true)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "IdAcomodador", "Cajon", "Nivel", "Hora/Entrada", "Minutos/Cajon"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Lista Actializada de Cajones ocupados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private String hora( Date horaInicio){

    //hora de inicio no la traes de JtextField, si no que la tomas de donde la tengas de tipo Date
    Calendar calInicio =Calendar.getInstance();
    calInicio.setTime(horaInicio);//pasamos horaInicio a Calendar
    Calendar calSalida =Calendar.getInstance();//hora actual sistema
    //calculamos diferencia
    int difHoras =calSalida.get(Calendar.HOUR_OF_DAY) - calInicio.get(Calendar.HOUR_OF_DAY);
    int difMinutos =calSalida.get(Calendar.MINUTE) - calInicio.get(Calendar.MINUTE);
    int difSegundos =calSalida.get(Calendar.SECOND) - calInicio.get(Calendar.SECOND);
    Calendar calDif =Calendar.getInstance();//variable para diferencia de tiempo
    calDif.set(Calendar.HOUR_OF_DAY, difHoras);
    calDif.set(Calendar.MINUTE, difMinutos);
    calDif.set(Calendar.SECOND, difSegundos);
    int totalminutos =calDif.get(Calendar.HOUR) * 60 + calDif.get(Calendar.MINUTE);
    String strTotalMinutos =Integer.toString(totalminutos);
return strTotalMinutos;
}
    private void VerCajones(){   
    
TicketQuerys tq = new TicketQuerys();
    
    
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    modelo = (DefaultTableModel) jTable1.getModel();
  jTable1.setModel(modelo);
        
        
        List<Ticket> lista = tq.listar();
        Object[] objeto = new Object[6];
        for (int i = 0; i < autos.size(); i++) {
           
              objeto[0] = autos.get(i).getFolio();
              objeto[1] = autos.get(i).getIdEmpleado();
             objeto[2] = autos.get(i).getIdCajon();
            objeto[3] = autos.get(i).getNivel();
            objeto[4] = autos.get(i).getTiempoEntrada();
            objeto[5] = hora(autos.get(i).getTiempoEntrada());
            
             
           
           
            modelo.addRow(objeto);
             
        }
        
}         
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AutosActivos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutosActivos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutosActivos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutosActivos2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AutosActivos2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
