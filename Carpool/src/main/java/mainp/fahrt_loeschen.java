package mainp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stores.Store;




@WebServlet("/fahrt_loeschen")
public class fahrt_loeschen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Store fahrtstore = new Store();
			int fid = Integer.parseInt(request.getParameter("fid"));
			fahrtstore.deleteFahrt(fid);
			request.getRequestDispatcher("/fahrt_loeschen.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Store fahrtstore = new Store();
		int fid = Integer.parseInt(request.getParameter("fid"));
		fahrtstore.deleteFahrt(fid);
    	
		} catch(Exception e) {
		e.printStackTrace();
			}
	
	}

}
