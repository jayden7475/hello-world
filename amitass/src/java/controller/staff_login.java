/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.*;
import java.util.Base64;
import model.CustomExceptions;
import model.Staff;
/**
 *
 * @author User
 */
@WebServlet(name = "staff_login", urlPatterns = {"/admin/staff_login"})
public class staff_login extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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
     * @throws model.CustomExceptions.InvalidCredentials
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        try{
            String staff_id = request.getParameter("staff_id");
            String password = request.getParameter("psw");

            Query query = em.createNamedQuery("Staff.findByStaffId");
            query.setParameter("staffId", staff_id); // set the value of the staffId parameter
            Staff result = (Staff) query.getSingleResult(); // execute the query and get the result
            
            if(password.equals(result.getPassword())){
                // Generate Session using base64
                String staffLogin_session = Base64.getEncoder().encodeToString(staff_id.getBytes());
                String staffPosition_session = Base64.getEncoder().encodeToString(result.getPosition().getBytes());
                
                // Store data in Session
                HttpSession session = request.getSession();
                session.setAttribute("staff_login_sesion", staffLogin_session);
                session.setAttribute("staff_position_sesion", staffPosition_session);
                response.sendRedirect("/amitass/admin/index.jsp");
                
            }else{
                throw new CustomExceptions.InvalidCredentials();
            }

            
        }catch (NoResultException | CustomExceptions.InvalidCredentials ex){
            request.setAttribute("errorMessage", ex.getMessage());
            String redirectUrl = "/amitass/admin/index.jsp";
            String script = "<script>alert('Invalid Credentials!!'); window.location.href='" + redirectUrl + "';</script>";
            response.setContentType("text/html");
            response.getWriter().print(script);
        }catch (Exception ex) {
            Logger.getLogger(staff_login.class.getName()).log(Level.SEVERE, null, ex);
        } 
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
