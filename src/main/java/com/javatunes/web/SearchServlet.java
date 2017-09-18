package main.java.com.javatunes.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet implements Servlet
{

    private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // Set content-type and get PrintWriter
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	      // Send back some HTML
	      String keyword = request.getParameter("keyword");
	      out.println("<HTML>");
	      out.println("<HEAD><TITLE>Search Results</TITLE></HEAD>");
	      out.println("<BODY>");
	      out.println("<h2 style=\"color:#069\">Process Report</h2>");
	      out.println("<P>Search Results for "+ keyword +" :");
	      out.println("</BODY>");
	      out.println("</HTML>");

	      // Close the PrintWriter
	      out.close();
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
