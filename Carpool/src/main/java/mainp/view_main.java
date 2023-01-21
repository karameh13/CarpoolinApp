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


@WebServlet("/view_main")
public class view_main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public view_main() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try 
    	{
    		Store fahrtstore = new Store();
    		
    		ArrayList<fahrt> resfahrten = fahrtstore.getResFahrten();
    		request.setAttribute("fahrtlist01", resfahrten);
    	
    		ArrayList<fahrt> of_fahrten = fahrtstore.getAlleFahrten();
    		request.setAttribute("fahrtlist02", of_fahrten);
	
    		request.getRequestDispatcher("/hauptseite.jsp").forward(request, response);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
