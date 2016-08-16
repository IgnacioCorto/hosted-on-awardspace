    // NOTA: HAY QUE AGREGAR ESTO EN web.xml
    // =========================================

    // <servlet>
        // <servlet-name>aco</servlet-name>
        // <servlet-class>ServletExample</servlet-class>
    // </servlet>

    // <servlet-mapping>
        // <servlet-name>aco</servlet-name>
        // <url-pattern>/servlet/ServletExample</url-pattern>
    // </servlet-mapping>

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletExample extends HttpServlet {
    public void doGet (HttpServletRequest request, 
                       HttpServletResponse response)
                       throws ServletException, IOException 
    {
        String title = "Ejemplo de Servlet";
        response.setContentType("text/html");
        
        String salida = 
              "<html><head><title>"+title+"</title></head><body>"
            + Math.random()
            + "</body></html>";
        
        PrintWriter out = response.getWriter();
        out.println(salida);
        out.close();

    }
}