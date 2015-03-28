/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.UserBean;
import database.UserDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yue
 */
public class RegistrationServlet extends HttpServlet {

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
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet RegistrationServlet</title>");
//        out.println("</head>");
//        out.println("<body>");
        register(request, response);
//        out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
//        out.println("</body>");
//        out.println("</html>");
    }
//}

    private void register(HttpServletRequest request, HttpServletResponse response) {
        UserDatabase db = new UserDatabase();
        db.establishConnection();
        boolean isAccountUsed = db.doesAccountExist(request.getParameter("id"));
        try {
            PrintWriter out = response.getWriter();

            if (isAccountUsed) {
                out.println("<p>ID: " + request.getParameter("id")
                        + " has be taken. Please try a different id</p>");
                out.println("<p><a HREF=\"/MultiTier/index.jsp\">Back to home</a></p>");
                out.println("<p><a HREF=\"/MultiTier/register.jsp\">Register Again</a></p>");
            } else {
                db.addNewUser(request.getParameter("id"), request.getParameter("name"), request.getParameter("pwd"));
//                String[] rlt = db.getUserTradeRecords(request.getParameter("usr_id"));
                UserBean ub = new UserBean();
                ub.setId(request.getParameter("id"));
                ub.setName(request.getParameter("name"));
                ub.setPwd(request.getParameter("pwd"));
                ub.setShare(0);
                ub.setUse(0);
                request.setAttribute("user", ub);
                request.setAttribute("usr_id", request.getParameter("id"));
                request.setAttribute("usr_pwd", request.getParameter("pwd"));
                System.out.println(ub + " " + request.getParameter("id") + request.getParameter("pwd"));
                getServletContext().getRequestDispatcher("/LogonServlet").
                        forward(request, response);
            }

        } catch (IOException | ServletException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
