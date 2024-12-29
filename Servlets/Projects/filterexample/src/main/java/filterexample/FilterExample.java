package filterexample;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

// @WebFilter sería parecido a @WebServlet.
// La parte importante es urlPatterns. Cuando se va a esa ruta, el filtro se ejecuta.
// Notar que /SetCookies es la misma url que tenemos en la anotación @WebServlet
// de la clase SetCookies.java
// Para ejecutar un filtro sobre todos los servlet, se indica: urlPatterns = {"/*"}
@WebFilter(filterName = "FilterExample", urlPatterns = { "/SetCookies" })
public class FilterExample implements Filter {

  public void destroy() {
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // TODO Auto-generated method stub
    // place your code here

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // set a cookie
    String username = request.getParameter("username");

    // Si el username no es hacker seguimos (forward) a la url /SetCootkies
    if (!"hacker".equalsIgnoreCase(username)) {
      chain.doFilter(request, response);
    } else {
      out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\" />\r\n"
          + "<title>Filter Example</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
          + "	<h1>Sorry! we don't entertain hackers.. :D</h1>\r\n" + "</body>\r\n" + "</html>");
    }

  }

  public void init(FilterConfig fConfig) throws ServletException {
  }

}
