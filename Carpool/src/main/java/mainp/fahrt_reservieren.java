package mainp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.reservieren;
import stores.Store;




@WebServlet("/fahrt_reservieren")
public class fahrt_reservieren extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/fahrt_reservieren.jsp").forward(request, response);
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Store fahrtStore = new Store();
			//int kunde = Integer.parseInt(request.getParameter("kunde"));
			int fahrt = Integer.parseInt(request.getParameter("fid"));
		//	int anzPlaetze = Integer.parseInt(request.getParameter("anzPlaetze"));
			
        	reservieren r = new reservieren();
        	
        	r.setKunde(9);
        	r.setFahrt(fahrt);
        	r.setAnzPlaetze(1);
        	
        	fahrtStore.reservieren(r);

			
			request.getRequestDispatcher("/fahrt_reservieren.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
