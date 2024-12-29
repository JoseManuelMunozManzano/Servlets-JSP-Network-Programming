package servletsession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SetSession")
public class SetSession extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Obtenemos la un session object (o se crea si no existe, de ahí el parámetro true)
    HttpSession session = request.getSession(true);

    // Obtenemos el valor mandado en SessionExample y lo guardamos como atributo de la sesión, como un par clave-valor
    String username = request.getParameter("username");
    session.setAttribute("username", username);

    // Informamos en el browser información de la sesión
    out.println("ID " + session.getId());
    out.println("Created: " + new Date(session.getCreationTime()));
    out.println("Last Accessed: " + new Date(session.getLastAccessedTime()));

    out.println("<!DOCTYPE html>\r\n" +
        "<html>\r\n" +
        "<head>\r\n" +
        "<meta charset=\"UTF-8\" />\r\n" +
        "<title>Session Example</title>\r\n" +
        "</head>\r\n" +
        "<body>\r\n" +
        "\r\n" +
        "	<h1>Session Parameters are set! Visit our website again..</h1>\r\n" +
        "</body>\r\n" +
        "</html>");
  }

}
