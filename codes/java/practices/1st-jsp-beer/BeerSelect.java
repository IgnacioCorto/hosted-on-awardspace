package com.example.web;

import com.example.model.BeerExpert;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BeerSelect extends HttpServlet {
    public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
                    throws IOException, ServletException {

        /* Version 1 */
        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        // out.println("Beer Selection Advice<br>");
        // String c = request.getParameter("color");
        // out.println("<br />Got beer color: " + c);
        
        /* Version 2 (needs v1) */
        // BeerExpert be = new BeerExpert();
        // List<String> result = be.getBrands(c);
        // Iterator it = result.iterator();
        // while(it.hasNext()) out.print("<br />Try: "+it.next());
        
        /* Version 3 */
        String c = request.getParameter("color");
        BeerExpert be = new BeerExpert();
        List<String> result = be.getBrands(c);
        request.setAttribute("styles",result);
        RequestDispatcher view = 
            request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
        
        
    }
}
