package main.java.com.javatunes.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.javatunes.util.MusicItem;
import main.java.com.javatunes.util.SearchUtility;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String itemID = request.getParameter("itemID");
		 //request.setAttribute("itemID",itemID );
		 
		    HttpSession session = request.getSession();
		    Collection res = (Collection<MusicItem>) session.getAttribute("res");
		    res.add(SearchUtility.findById(itemID));
		    
		      //HttpSession session = request.getSession();
		      //Collection<MusicItem> res = new ArrayList<MusicItem>();
		      //request.setAttribute("res",res );
		      
	      //new ArrayList<MusicItem>();
	      //request.setAttribute("res",res );
		 
		 //HttpSession session = request.getSession();
		// session.setAttribute("itemID", itemID);
		 
		 RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/jsp/cartDisplay.jsp");
	      rd.forward(request, response);
	}
*/
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // Read the parameter from the "Add to Cart" link
	      String itemID = request.getParameter("itemID");

	      // Session management - create new or get reference to existing
	      HttpSession session = request.getSession();

	      // Shopping cart management - create new or get reference to existing
	      Collection<MusicItem> cart = (Collection<MusicItem>) session.getAttribute("cart");
	      if (cart == null)  // first visit: session does not have a "cart"
	      {
	         cart = new ArrayList<MusicItem>();  // create new cart
	         session.setAttribute("cart", cart);  // add it to session
	      }

	      // Shopping cart content management (add item if not already in cart)
	      if (itemID != null)
	      {
	         MusicItem item = SearchUtility.findById(itemID);
	         if (!cart.contains(item))  // based on equals() method of ItemValue
	         {
	        	 System.out.println("Adding item: " + item);
	            cart.add(item);
	         }
	      }

	      // forward to /jsp/cartDisplay.jsp
	      this.getServletContext().getRequestDispatcher("/jsp/cartDisplay.jsp").
	         forward(request, response);
	}



}
