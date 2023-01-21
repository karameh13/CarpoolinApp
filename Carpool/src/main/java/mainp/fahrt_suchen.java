package mainp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.fahrt;
import stores.Store;




@WebServlet("/fahrt_suchen")
public class fahrt_suchen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Store fahrtstore = new Store();
       
    
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String startort = request.getParameter("startort");
			String zielort = request.getParameter("zielort");
			
			
			
    		ArrayList<fahrt> fahrten = fahrtstore.getFahrt_suchen(startort, zielort);
    		
    		request.setAttribute("fahrtlistsuche", fahrten);
			
			request.getRequestDispatcher("/fahrt_suchen.jsp").forward(request, response);
    		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String von = request.getParameter("startort");
			String bis = request.getParameter("zielort");
			
			fahrt f = new fahrt();
	    	
	    	f.setStartort(von);
	    	
        	fahrtstore.getFahrt_suchen(von, bis);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
