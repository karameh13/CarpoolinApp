package mainp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.fahrt;
import stores.Store;



@WebServlet("/fahrt_erstellen")
public class fahrt_erstellen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Store fahrtstore = new Store();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.getRequestDispatcher("/fahrt_erstellen.ftl").forward(request, response);
			return;
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		try {
			String von = request.getParameter("startort");
			String bis = request.getParameter("zielort");
			int maxPlaetze = Integer.parseInt(request.getParameter("maxPlaetze"));
			double fahrtkosten = Double.parseDouble(request.getParameter("fahrtkosten"));
	    	int transportmittel = Integer.parseInt(request.getParameter("transportmittel"));
	    	String fahrtdatumzeit = request.getParameter("fahrtdatumzeit");
	    	String beschreibung = request.getParameter("beschreibung");
	    	
			
			
			fahrt f = new fahrt();
	    	
	    	f.setStartort(von);
	    	f.setZielort(bis);
	    	f.setFahrtdatumzeit(fahrtdatumzeit);
	    	f.setMaxPlaetze(maxPlaetze);
	    	f.setFahrtkosten(fahrtkosten);
	    	f.setAnbieter(9);
	    	f.setTransportmittel(transportmittel);
	    	
	    	if(beschreibung.equals("")) {
	    		f.setBeschreibung("Keine Beschreibung");
	    	}
	    	else {
	    		f.setBeschreibung(beschreibung);
	    	}
	    	
        	fahrtstore.addFahrt(f);
        	response.sendRedirect("http://localhost:8080/CarpoolApp/view_main");
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
