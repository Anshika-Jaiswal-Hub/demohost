/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tech.blog.servlets;

import com.tech.blog.dao.UserDatabase;
import com.tech.blog.entities.User;
import com.tech.blog.helper.Helper;
import com.tech.blog.helper.connectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;

/**
 *
 * @author Anshika Jaiswal
 */
@MultipartConfig
public class EditServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
        
            
            
            //Fetch all data
            String userName = request.getParameter("user_name");
            String userPassword=request.getParameter("user_password");
            String userAbout=request.getParameter("user_About");
            Part part = request.getPart("image");
            
            
            if (part != null) {
    String userImage = part.getSubmittedFileName();
    
    HttpSession session = request.getSession();
    User currentUser = (User) session.getAttribute("currentUser");
    currentUser.setName(userName);
    currentUser.setPassword(userPassword);
    currentUser.setAbout(userAbout);
    currentUser.setProfile(userImage);
    
    UserDatabase database = new UserDatabase(connectionProvider.getConnection());
    boolean isUpdated = database.setNewData(currentUser);
    
    if (isUpdated) {
                    try {
                        String rootPath = getServletContext().getRealPath("/");
                        String imagePath = rootPath + "Image" + File.separator + currentUser.getProfile();

                        // Delete the existing image
                        Helper.deleteFile(imagePath);
                        // Save the new image
                        if (Helper.saveFile(part.getInputStream(), imagePath)) {
                            out.println("updated");
                            return; // Exit the servlet after successful update
                        } else {
                            out.println("File saving failed");
                        }

                    } 
                    catch (IOException e) {
                        out.println("Error processing file: " + e.getMessage());
                    }
                } 
                else {
                    out.println("not updated");
                }
                } 
                else {
                out.println("No image uploaded");
                }
            
            
            
            
            
            out.println("</body>");
            out.println("</html>");
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
