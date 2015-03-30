/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.UserDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yue
 */
public class CommandsServlet extends HttpServlet {

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
        String requests = request.getParameter("select_").toString();
        System.out.println(request.getSession().getId());
        String usr = request.getParameter("usr_id");
        String[] results = udb.getUserTradeRecords(request.getParameter("usr_id"));
        ArrayList<Cookie> cookieLst = new ArrayList<>();
        Cookie c1 = new Cookie("id", results[0]);
        cookieLst.add(c1);
        Cookie c2 = new Cookie("name", results[1]);
        cookieLst.add(c2);
        Cookie c3 = new Cookie("pwd", results[2]);
        cookieLst.add(c3);
        Cookie c4 = new Cookie("shared", results[3]);
        cookieLst.add(c4);
        Cookie c5 = new Cookie("used", results[4]);
        cookieLst.add(c5);
        for (Cookie cookie : cookieLst) {
            response.addCookie(cookie);
        }
        try {
            request.setAttribute("item_list", udb.getAvailableItemsList());
            request.setAttribute("under_use_list", udb.getUserItemsList(request.getParameter("id")));
            request.setAttribute("cookies", cookieLst);
        } catch (Exception ex) {
            Logger.getLogger(LogonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch (requests) {
            case "list":
                // text               
                String task1 = request.getParameter("select_input");
                udb.addNewItem(task1);
                udb.incrementUserAttribute(usr, "SHARED");
//                response.sendRedirect("task_complete.jsp");
                request.getRequestDispatcher("/login_success.jsp").forward(request, response);
                break;
            case "return":
                // num
                String task2 = request.getParameter("select_input");
                udb.unassignItemFrom(Integer.parseInt(task2));
//                response.sendRedirect("task_complete.jsp");
                request.getRequestDispatcher("/login_success.jsp").forward(request, response);
                break;
            case "use":
                // num                
                String task3 = request.getParameter("select_input");
                System.out.println("user id: " + usr);
                String[] test = udb.getItemRecords(Integer.parseInt(task3));
                if (test[0] != null) {
                    udb.assginItemTo(Integer.parseInt(task3), usr);
                    udb.increaseItemHeatByOne(Integer.parseInt(task3));
                    udb.incrementUserAttribute(usr, "USED");
                    request.getRequestDispatcher("/login_success.jsp").forward(request, response);
//                    response.sendRedirect("task_complete.jsp");
                }
                break;
            default:
                break;
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