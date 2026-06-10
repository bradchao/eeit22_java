package tw.brad.viewer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/FoodViewer")
public class FoodViewer extends HttpServlet {
	private static final String TEMPLATE_PATH = "/WEB-INF/views/view1.html";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String template;
		try {
			template = readTemplate(TEMPLATE_PATH);
		} catch (Exception e) {
			template = "ERROR";
			System.out.println(e);
		}
		
		response.getWriter().print(template);
		response.flushBuffer();
		
	}
	
	private String readTemplate(String path) throws Exception{
		//System.out.println(getServletContext().getContextPath());
		try(InputStream in = getServletContext().getResourceAsStream(path);
			BufferedInputStream bin = new BufferedInputStream(in)){
			return new String(bin.readAllBytes(), StandardCharsets.UTF_8);
		}catch(Exception e) {
			System.out.println(e);
			throw new Exception("Template NOT FOUND");
		}
	}
	

}
