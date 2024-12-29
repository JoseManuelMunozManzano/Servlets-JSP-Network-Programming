package servletsession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SessionExample")
public class SessionExample extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Obtenemos toda la información de la sesión o, si fuera necesario crea un session object.
    HttpSession session = request.getSession(true);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String value = "Stranger";

    // Obtenemos todos los nombres de los atributos
    Enumeration e = session.getAttributeNames();

    // Obtenemos todos los pares clave-valor
    // Ver como value se escribe luego en el HTML de salida
    while (e.hasMoreElements()) {
      String key = (String) e.nextElement();
      value = session.getAttribute(key).toString();
    }

    out.println("<!DOCTYPE html>\r\n" +
        "<html>\r\n" +
        "<head>\r\n" +
        "<meta charset=\"UTF-8\" />\r\n" +
        "<title>Session Example</title>\r\n" +
        "</head>\r\n" +
        "<body>\r\n" +
        "\r\n" +
        "	<h1>Session Example</h1>\r\n" +
        "<h3 style=\"color:red\">Welcome Back " + value + "!</h3>" +
        "	<h3>Tell us your name to greet you, the next time you visit our site!</h3>\r\n" +
        "	\r\n" +
        "	<form action=\"SetSession\" method=\"POST\">\r\n" +
        "		Name: <input type=\"text\" name=\"username\"><br>\r\n" +
        "		\r\n" +
        "		<br /><input type=\"submit\" value=\"Send my name!\">\r\n" +
        "	</form>\r\n" +
        "	\r\n" +
        "	\r\n" +
        "</body>\r\n" +
        "</html>");
  }

}
