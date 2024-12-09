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

public class ThreadReporteNomina  implements Runnable  {
    Statement  sent;
         Connection con;
     
     int salari;
     String f1;
     String f2;
     public ThreadReporteNomina (int salario, String fecha1, String fecha2)
             
     {
         this.salari= salario;
         this.f1 = fecha1;
         this.f2 = fecha2;
     }
      
        
    @Override
    public void run() 
    {
        

    try{
        
     con=Conex.getConnection();
         
         
PreparedStatement ps = con.prepareStatement("select b.id_empleado, e.nombre, e.apellido, e.puesto, count(*) as 'servicios' from empleado e, boleto b where b.id_empleado=e.id_empleado AND b.entrada  group by e.nombre;");
            
           
          
           ResultSet rst = ps.executeQuery();
            


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
                    PdfWriter.getInstance(pdfsup, new FileOutputStream(new File(chooser.getSelectedFile(),"reporte"+".pdf")));

                    pdfsup.open();
                    
                     pdfsup.add(new Paragraph("Buenas Manos ",FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
                   
                    pdfsup.add(new Paragraph(".."));

                     PdfPTable tablesup= new PdfPTable(6);

                    PdfPCell cell = new PdfPCell(new Paragraph("Reporte de Nomina"));
                    cell.setColspan(8);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.WHITE);

                    tablesup.addCell(cell);

                    tablesup.addCell("IdEmpleado");
                    tablesup.addCell("Nombre");
                    tablesup.addCell("Apellido");
                    tablesup.addCell("Puesto");
                     tablesup.addCell("Servicios");
                      tablesup.addCell("Salario");
             int count=0;
              while (rst.next()) {
                    int salario = salari;
                    if(count++ < 5){
                        salario += salario * .10;
                    }
              
                String id = rst.getString(1);
                String nombre = rst.getString(2);
                String apelli = rst.getString(3);
                String puesto= rst.getString(4);
                String servic = rst.getString(5);
                String sueldo = String.valueOf(salario);
                
                
             
                tablesup.addCell(id);
                tablesup.addCell(nombre);
                tablesup.addCell(apelli);
                tablesup.addCell(puesto); 
                tablesup.addCell(servic); 
                tablesup.addCell(sueldo); 
                

                

              }
                
                JOptionPane.showMessageDialog(null, "Nomina guardada...");
 
              pdfsup.add(tablesup);
                pdfsup.close();

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


