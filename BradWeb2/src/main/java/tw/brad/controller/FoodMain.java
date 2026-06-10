package tw.brad.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FoodMain")
public class FoodMain extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {}
		
		// 2. Model
		
		// 3. Viewer
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("").forward(request, response);
	}

}
