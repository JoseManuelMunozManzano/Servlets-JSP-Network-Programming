package addtwonumbers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddTwoNumbers")
public class AddTwoNumbers extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = "Using GET Method to Read Form Data";

		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));

		out.println("<!DOCTYPE html><html>\n" + "<head><title>Result</title></head>\n" + "<body>\n"
				+ "<h1>And the result is..</h1>\n" + "<h1>" + (number1 + number2) + "</h1>...  :P\n" + "</body></html>");
	}

}
