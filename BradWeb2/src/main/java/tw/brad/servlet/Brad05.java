package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Brad05")
public class Brad05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		String x, y, result;
		x = y = result = "";
		
		try {
			x = request.getParameter("x");
			y = request.getParameter("y");
			int r =  Integer.parseInt(x) + Integer.parseInt(y);
			result += r;
		}catch(Exception e) {
			x = y = result = "";
			System.out.println(e);
		}		
		
		//---------------------------------
		response.setContentType("text/html; charset=UTF-8");	
		PrintWriter out = response.getWriter();
		
		// C:\Users\User\eclipse-workspace\BradWeb2\src\main\webapp\brad05.html
		BufferedInputStream bin = new BufferedInputStream(
			new FileInputStream("C:\\Users\\User\\eclipse-workspace\\BradWeb2\\src\\main\\webapp\\brad05.html"));
		byte[] data = bin.readAllBytes();
		String html = new String(data);
		
		out.print(String.format(html, x, y, result));
		
		
	}

}
