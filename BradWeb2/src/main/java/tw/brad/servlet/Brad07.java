package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@MultipartConfig(
		location = "C:\\Users\\User\\git\\repository\\BradWeb2\\src\\main\\webapp\\upload"
		)
@WebServlet("/Brad07")
public class Brad07 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String ip = request.getRemoteAddr();
		
		Part part = request.getPart("upload");
		String type = part.getContentType();
		String name = part.getName();
		long size = part.getSize();
		String sname = part.getSubmittedFileName();
		
		System.out.println(ip);
		System.out.println(type);
		System.out.println(name);
		System.out.println(size);
		System.out.println(sname);
		
		
		if (size > 0) {
			part.write(sname);
		}else {
			System.out.println("Upload Failure");
		}
		System.out.println("------");
		
		
		response.setContentType("text/html; charset=UTF-8");		
	
	}

}
