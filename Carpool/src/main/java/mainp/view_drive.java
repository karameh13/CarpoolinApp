package mainp;

import java.io.IOException;

import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bewertung;
import domain.fahrt;
import stores.Store;



@WebServlet("/view_drive") 

public class view_drive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		Store fahrtstore = new Store();
		int fid = Integer.parseInt(request.getParameter("fid"));
			
    		try 
    		{
    			
    	
    			ArrayList<fahrt> fahrtInfo = fahrtstore.getFahrt(fid);
    		
    			request.setAttribute("fahrtlist", fahrtInfo);
    			
    			
    			Store bewertungstore = new Store();
    	
    			ArrayList<bewertung> bewertungInfo = bewertungstore.getBewertung(fid);
    			request.setAttribute("bewertunglist", bewertungInfo);
    			
    			
    			ArrayList<bewertung> bewertungAvg = bewertungstore.getAvgBewertung(fid);
    			request.setAttribute("bewertunglist01", bewertungAvg);
    		
    			
    			request.getRequestDispatcher("/informationen.jsp").forward(request, response);
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    		
    		
    	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
