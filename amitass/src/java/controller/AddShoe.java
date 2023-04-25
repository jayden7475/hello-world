/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;
import model.Shoes;

/**
 *
 * @author User
 */
@WebServlet(name = "AddShoe", urlPatterns = {"/AddShoe"})
@MultipartConfig(
     fileSizeThreshold = 1024 * 1024 * 1,
     maxFileSize = 1024 * 1024 * 10,
     maxRequestSize = 1024 * 1024 * 1
)
public class AddShoe extends HttpServlet {
    
@PersistenceContext EntityManager em;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occur
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  PrintWriter out = response.getWriter();
        try {
            String id = request.getParameter("id");
            
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            double price = Double.parseDouble(request.getParameter("price"));
            String size = request.getParameter("size");
            int stock = Integer.parseInt(request.getParameter("stock"));
            Part filePart = request.getPart("png");
            String imageName = filePart.getSubmittedFileName();
            String imagesFolderPathStr = request.getServletContext().getRealPath("/shoes_images/");
  
            File imageFolder = new File(imagesFolderPathStr);
            File destination = new File(imagesFolderPathStr,imageName);
  
  
            try(InputStream inputStream = filePart.getInputStream();
                FileOutputStream fos = new FileOutputStream(destination)) {

                int byteRead;
                
                final byte[] buffer = new byte[8192];
                
                while((byteRead = inputStream.read(buffer)) != -1) {
                    fos.write(buffer, 0, byteRead);
                }
                
                //response.sendRedirect("Display.jsp");
            
            }catch(Exception ex) {
                out.println(ex.getMessage());
            }
            
            Shoes shoe = new Shoes();
            shoe.setShoesId(id);
            shoe.setShoesName(name);
            shoe.setShoesType(type);
            shoe.setShoesPrice(price);
            shoe.setShoesSize(size);
            shoe.setShoesStock(stock);
            shoe.setShoesPng(imageName);
            
            ShoesDa shoesDa = new ShoesDa();
            shoesDa.addRecord(shoe);
            
            response.sendRedirect("admin/Display.jsp");
            
        }catch(Exception ex) {
            out.println(ex.getMessage());
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
