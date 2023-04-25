/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.UserTransaction;
import model.Review;

/**
 *
 * @author USER
 */
@WebServlet(name = "ReviewComment", urlPatterns = {"/ReviewComment"})
public class ReviewComment extends HttpServlet {
    @PersistenceContext EntityManager em;
    @Resource UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
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
        //processRequest(request, response);
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
        //processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        try {
                    Query query = em.createNamedQuery("Review.findAll");
                    List<Review> reviewList = query.getResultList();
                    
                    int reviewSize = reviewList.size();
                    
                    //Review ID
                    String reviewID = String.format("R%04d", reviewSize+1);
                    //Customer Comment
                    String customerComm = request.getParameter("comment").trim();
                    //Review Date
                    Date reviewDate = new Date(); 
                    //Rating
                    String[] ratingValues = request.getParameterValues("star");
                    int rate = Integer.parseInt(ratingValues[ratingValues.length-1]);
                    
                    Review reviewObj = new Review();
                    reviewObj.setReviewId(reviewID);
                    reviewObj.setCustomerComm(customerComm);
                    reviewObj.setDateReview(reviewDate);
                    reviewObj.setRate(rate);
                    
                    utx.begin();
                    em.persist(reviewObj);
                    utx.commit();
                    
                    
                    
      
        }catch(NumberFormatException ex) {
            out.println(ex.getMessage());
        }catch(Exception ex) {
            out.println(ex.getMessage());
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
