package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class DownloadCurElizaDoc extends HttpServlet {
	public void doGet (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException
					, ServletException    //BeerSelect v3 
					{
		
		response.setContentType("application/msword");
		
		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream("/Nuevo CurEliza.doc");
		
		int read = 0;
		byte[] bytes = new byte[1024];
		
		OutputStream os = response.getOutputStream();
		while ( (read = is.read(bytes)) != 1 ) {
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
	}
}