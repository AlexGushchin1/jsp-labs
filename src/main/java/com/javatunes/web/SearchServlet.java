package main.java.com.javatunes.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.javatunes.util.MusicItem;
import main.java.com.javatunes.util.SearchUtility;

public class SearchServlet extends HttpServlet implements Servlet
{

    private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      response.setContentType("text/html");

	      String keyword = request.getParameter("keyword");
	      
	      Collection<MusicItem> musicitems = SearchUtility.findByKeyword(keyword);
	      request.setAttribute("results", musicitems);
	      

	      RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/jsp/searchResults.jsp");
	      rd.forward(request, response);
	      
//	      PrintWriter out = response.getWriter();     
//	      out.println("<HTML>");
//	      out.println("<HEAD><TITLE>Search Results</TITLE></HEAD>");
//	      out.println("<BODY>");
//	      out.println("<h2 style=\"color:#069\">Process Report</h2>");
//	      out.println("<P>Search Results for "+ keyword +" :");
//	      out.println("<TABLE>");
//	      for (MusicItem item : musicitems ) {
//	    	  out.println("<TR>");
//			    	  out.println("<TD>"+" "+item.getTitle());
//			    	  out.println("</TD>");
//			    	  out.println("<TD>"+ " "+item.getArtist());
//			    	  out.println("</TD>");
//	    	  out.println("<T/R>");
//	      }
//	      out.println("</TABLE>");
	      

//	      out.println("</BODY>");
//	      out.println("</HTML>");

	      // Close the PrintWriter
//	      out.close();
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
