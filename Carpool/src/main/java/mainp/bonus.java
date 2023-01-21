package mainp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.benutzer;
import domain.fahrt;
import stores.Store;



@WebServlet("/bonus")
public class bonus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Store fahrtstore = new Store();
		
		try {
			
    		
    		ArrayList<benutzer> bn = fahrtstore.getBesterFahrer();
    		request.setAttribute("benutzerliste", bn);
    		
    	
    		ArrayList<fahrt> b_liste = fahrtstore.getBester_Fahrer();
    		request.setAttribute("bid_f_liste", b_liste);
	
    		request.getRequestDispatcher("/bonus.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
