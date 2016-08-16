package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.example.model.BeerExpert;

public class BeerSelect extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        
        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        // out.println("beer Selection Advice<br>");
        String c = request.getParameter("color");
        // out.println("<br>Got beer color "+c);
        // out.println("<hr>");
        
        BeerExpert be = new BeerExpert();
        
        // for(String aBeer:be.getBrands(c)) {
            // out.println("<br>Expert Recommends: "+aBeer);
        // }
        
        request.setAttribute("styles",be.getBrands(c));
        RequestDispatcher view = request.getRequestDispatcher
                ("Vista.jsp");
        view.forward(request, response);
    
    }
}
