package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import beans.UserBean;
import database.UserDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yue
 */
public class RegisterServlet extends HttpServlet {

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
        UserDatabase db = new UserDatabase();
        db.establishConnection();
        boolean isAccountUsed = db.doesAccountExist(request.getParameter("id"));
        if (isAccountUsed) {
            getServletContext().getRequestDispatcher("/login_failure.jsp").forward(request, response);
        } else if (request.getAttribute("id") != null) {
            isAccountUsed = db.doesAccountExist(request.getAttribute("id").toString());
            if (isAccountUsed) {
                getServletContext().getRequestDispatcher("/login_failure.jsp").forward(request, response);
            }
        }
        db.addNewUser(request.getParameter("id"), request.getParameter("name"), request.getParameter("pwd"));
        UserBean ub = (UserBean) request.getSession().getAttribute("user");
        ub.setId(request.getParameter("id"));
        ub.setName(request.getParameter("name"));
        ub.setPwd(request.getParameter("pwd"));
        request.getSession().setAttribute("user", ub);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("<html>");
            out.print("<head>");
            out.print("</head>");
            out.print("<body>");
            out.print("<p>Registration success</p>");
            out.print("<a HREF=\"/MultiTier/index.jsp\">Back to home</a>");
            out.print("</body>");
            out.print("</html>");
        }
//        request.getRequestDispatcher("/items_list.jsp").forward(request, response);
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
