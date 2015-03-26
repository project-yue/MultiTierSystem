/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AddressBean;
import beans.PersonBean;
import beans.PhoneNumber;
import database.UserDatabase;

/**
 *
 * @author mk29
 */
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PopulateServlet extends HttpServlet {

    private UserDatabase db; 
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        PersonBean p = new PersonBean();
        p.setName("Sam Dalton");
        p.setAge(26);
        AddressBean a = new AddressBean();
        a.setStreetNum("221b Baker Street");
        a.setSuburb("London");
        a.setCounty("Greater London");
        a.setPostcode("NW1 1AA");
        ArrayList al = new ArrayList();
        PhoneNumber ph = new PhoneNumber();
        ph.setStd("01895");
        ph.setStd("678901");
        al.add(ph);
        ph = new PhoneNumber();
        ph.setStd("0208");
        ph.setStd("8654789");
        al.add(ph);
        a.setPhoneNumbers(al);
        p.setAddress(a);
        req.setAttribute("person", p);
        RequestDispatcher rd = req.getRequestDispatcher("complexBean.jsp");
        rd.forward(req, res);
    }

}
