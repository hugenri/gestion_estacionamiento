/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;




import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ConsultasBD.Conex;
import java.sql.PreparedStatement;
/**
 *
 * @author zero
 */
public class ThreadBoleto  implements Runnable  {
  Statement  sent;
         Connection con;
     
     int folio;
     public ThreadBoleto(int folio)
             
     {
         this.folio = folio;
     }
      
        
    @Override
    public void run() 
    {
        

    try{
        
     con=Conex.getConnection();
         
          String sql =("SELECT c.cajon, c.nivel, a.marca, a.placa, id_empleado, id_Boleto FROM boleto, cajones c, auto a WHERE boleto.id_boleto= ? and boleto.id_auto = a.id_auto and c.id_cajon =boleto.id_auto ;"); 
 PreparedStatement ps =  con.prepareStatement("SELECT c.cajon, c.nivel, a.marca, a.placa, id_empleado, id_Boleto FROM boleto, cajones c, auto a WHERE boleto.id_boleto= ? and boleto.id_auto = a.id_auto and c.id_cajon =boleto.id_auto ;");
           ps.setInt(1, folio);
            
         ResultSet  rs = ps.executeQuery();
           
            


            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Save Backup");
            chooser.setApproveButtonText("Save");
            //disables the all filesoptioning here
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
//                System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
//                System.out.print("getSelectedFile() : "+chooser.getSelectedFile());


                // creating the pdf for supplier details using itext

                try {
                    Document pdfsup = new Document();
                    PdfWriter.getInstance(pdfsup, new FileOutputStream(new File(chooser.getSelectedFile(),folio+".pdf")));

                    pdfsup.open();
                    
                     pdfsup.add(new Paragraph("Buenas Manos",FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLUE)));
                    pdfsup.add(new Paragraph(new Date().toString()));
                    pdfsup.add(new Paragraph("----------------------------------------------------------------------------------------------------------------"));

                     PdfPTable tablesup= new PdfPTable(6);

                    PdfPCell cell = new PdfPCell(new Paragraph("Boleto Estacionamiento"));
                    cell.setColspan(8);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.CYAN);

                    tablesup.addCell(cell);

                    tablesup.addCell("Cajon");
                    tablesup.addCell("Nivel");
                    tablesup.addCell("Marca");
                    tablesup.addCell("Placa");
                     tablesup.addCell("Id Empleado");
                      tablesup.addCell("Folio");
 while(rs.next()){

              
                String v1 = rs.getString(1);
                String v2 = rs.getString(2);
                String v3 = rs.getString(3);
                String v4 = rs.getString(4);
                String v5 = rs.getString(5);
                 String v6 = rs.getString(6);
                
             
                tablesup.addCell(v1);
                tablesup.addCell(v2);
                tablesup.addCell(v3);
                tablesup.addCell(v4); 
                tablesup.addCell(v5); 
                tablesup.addCell(v6); 
                

                

                pdfsup.add(tablesup);
                pdfsup.close();
                JOptionPane.showMessageDialog(null, "Boleto salvado...");
 }

                } catch (Exception e) {
                    System.out.println("<<<"+e);
                
                }
            }else{
                System.out.println("No Selection");
            }} catch (Exception e) {
                    System.out.println(e);
                

      }
    }
}


         
    
