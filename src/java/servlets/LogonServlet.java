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
public class LogonServlet extends HttpServlet {

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
        UserDatabase udb = UserDatabase.INIT_DB();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogonServlet</title>");
            out.println("</head>");
            out.println("<body>");
            UserBean bean = (UserBean) request.getSession().getAttribute("user");
            if (!udb.doesAccountExist(request.getParameter("id"))) {
                out.println("<p>" + request.getParameter("id") + " has not been registered.</p>");
            } else if (udb.doesAccountExist(request.getParameter("id"))
                    && udb.matchPasswords(request.getParameter("pwd"), request.getParameter("id"))) {
                String[] rlt = udb.getUserTradeRecords(request.getParameter("id"));
                UserBean ub = (UserBean) request.getSession().getAttribute("user");
                ub.setId(rlt[0]);
                ub.setName(rlt[1]);
                ub.setPwd(rlt[2]);
//                ub.setShare(Integer.parseInt(rlt[3]));
//                ub.setUse(Integer.parseInt(rlt[4]));
                request.setAttribute("user", ub);
                try {
                    request.setAttribute("item_list", udb.getAvailableItemsList());
                    request.setAttribute("under_use_list", udb.getUserItemsList(request.getParameter("usr_id")));
                } catch (Exception ex) {
                    Logger.getLogger(LogonServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                udb.closeConnections();
                request.getRequestDispatcher("/items_list.jsp").
                        forward(request, response);
            } //            else if (request.getAttribute("user") != null) {
            //                UserBean ub1 = (UserBean) request.getAttribute("user");
            //                UserBean ub = new UserBean();
            //                ub.setId(ub1.getId());
            //                ub.setName(ub1.getName());
            //                ub.setPwd(ub1.getPwd());
            //                ub.setShare(ub1.getShare());
            //                ub.setUse(ub1.getUse());
            //                request.setAttribute("user", ub);
            //                try {
            //                    request.setAttribute("item_list", udb.getAvailableItemsList());
            //                    request.setAttribute("under_use_list", udb.getUserItemsList(request.getParameter("usr_id")));
            //                } catch (Exception ex) {
            //                    Logger.getLogger(LogonServlet.class.getName()).log(Level.SEVERE, null, ex);
            //                }
            //                udb.closeConnections();
            //                request.getRequestDispatcher("/items_list.jsp").
            //                        forward(request, response);
            //            }
            else if (!udb.matchPasswords(request.getParameter("usr_pwd"), request.getParameter("usr_id"))) {
                out.println("<p>Password is incorrect</p>");
            }
            udb.closeConnections();
            out.println("<p><a HREF=\"/MultiTier/index.jsp\">Return</a></p>");
            out.println("<p><a HREF=\"/MultiTier/register.jsp\">Register</a></p>");
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
