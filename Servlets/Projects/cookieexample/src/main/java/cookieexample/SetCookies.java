package cookieexample;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SetCookies")
public class SetCookies extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// set a cookie
    // Para borrar una cookie de una máquina cliente, no hay ninguna función.
    // Lo que se tiene que hacer es indicar un maxAge de 0.
		String username = request.getParameter("username");
		Cookie c = new Cookie("user", username);
		c.setMaxAge(60 * 60 * 24);
		response.addCookie(c);
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\" />\r\n" + 
				"<title>Cookies Example</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"	<h1>Cookies are set! Visit our website again..</h1>\r\n" + 
				"</body>\r\n" + 
				"</html>");
  }

}
