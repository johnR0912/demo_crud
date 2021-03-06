package PDF;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Productos", urlPatterns = {"/Productos"})
public class Productos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try{
            
            try{
                
                Connection cnn = null;
                Statement st = null;
                ResultSet rst = null;
                Class.forName("com.mysql.jdbc.Driver");
                cnn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_inventario?zeroDateTimeBehavior=convertToNull","root","");
                st = (Statement) cnn.createStatement();
                rst = st.executeQuery("SELECT * FROM tb_producto; ");
                
                if (cnn!=null){
                    try{
              Document documento = new Document();
              PdfWriter.getInstance(documento, out);
              documento.open();
              
              Paragraph par1 = new Paragraph();
              Font fontitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
              par1.add(new Phrase("Listado de Productos", fontitulo));
              par1.setAlignment(Element.ALIGN_CENTER);
              par1.add(new Phrase(Chunk.NEWLINE));
              par1.add(new Phrase(Chunk.NEWLINE));
              documento.add(par1);
              
              Paragraph par2 = new Paragraph();
              Font fondescrip = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK);
              par2.add(new Phrase("Productos almacenados.", fondescrip));
              par2.setAlignment(Element.ALIGN_CENTER);
              par2.add(new Phrase(Chunk.NEWLINE));
              par2.add(new Phrase(Chunk.NEWLINE));
              documento.add(par2);
              
              PdfPTable tabla = new PdfPTable(9 );
              
              PdfPCell celda1 = new PdfPCell (new Paragraph("id", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
              PdfPCell celda2 = new PdfPCell (new Paragraph("nombre", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
              PdfPCell celda3 = new PdfPCell (new Paragraph("stock", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
              PdfPCell celda4 = new PdfPCell (new Paragraph("precio", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
              PdfPCell celda5 = new PdfPCell (new Paragraph("medida", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
              PdfPCell celda6 = new PdfPCell (new Paragraph("esatdo", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
              PdfPCell celda7 = new PdfPCell (new Paragraph("categoria", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
              PdfPCell celda8 = new PdfPCell (new Paragraph("descripción", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
              PdfPCell celda9 = new PdfPCell (new Paragraph("fecha_entreda", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
               
              tabla.addCell(celda1);
              tabla.addCell(celda2);
              tabla.addCell(celda3);
              tabla.addCell(celda4);
              tabla.addCell(celda5);
              tabla.addCell(celda6);
              tabla.addCell(celda7);
              tabla.addCell(celda8);
              tabla.addCell(celda9);
              
              while (rst.next()){
                  tabla.addCell(rst.getString(1));
                  tabla.addCell(rst.getString(2));
                  tabla.addCell(rst.getString(3));
                  tabla.addCell(rst.getString(4));
                  tabla.addCell(rst.getString(5));
                  tabla.addCell(rst.getString(6));
                  tabla.addCell(rst.getString(7));
                  tabla.addCell(rst.getString(8));
                  tabla.addCell(rst.getString(9));
              }
              documento.add(tabla);

              documento.close();
          }catch(Exception ex){
              ex.getMessage();
          }  
                }
                
            }catch(Exception ex){
                ex.getMessage();
            }
          
        }
        finally{
            out.close();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
