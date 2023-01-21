package mainp;

import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.bewertung;
import domain.schreiben;
//import de.unidue.inf.is.domain.fahrt;
import stores.Store;




@WebServlet("/new_rating")
public class new_rating extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/fahrt_bewerten.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*
		try 
    	{
    		Store fahrt = new Store();
    		fid = Integer.parseInt(request.getParameter("fid"));
    		beid = Integer.parseInt(request.getParameter("beid"));
    		/*boolean check= course.checkAbgabe(kid, anummer);
    		 if(check)
    		 {
    			 ArrayList<aufgabe> kursDatei= course.getAbgabe(kid,anummer);
    			 request.setAttribute("list5", kursDatei);
    			 request.getRequestDispatcher("/new_assignment.jsp").forward(request, response);
    		 }
    		ArrayList<bewertung> rating = fahrt.getBewertung(fid);
			request.setAttribute("rating_list", rating);
    		
    		request.getRequestDispatcher("/fahrt_bewerten.jsp").forward(request, response);
    		
    		
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		
		try {
			Store ratingstore = new Store();
			
			
        	String textnachricht = request.getParameter("textnachricht");
        	//java.sql.Timestamp erstellungsdatum = java.sql.Timestamp.valueOf(request.getParameter("erstellungsdatum"));
        	int rating = Integer.parseInt(request.getParameter("rating"));
      
        	bewertung b = new bewertung();
        	
        	b.setTextnachricht(textnachricht);
        	//b.setErstellungsdatum("2022-02-10-10.00.00.000000");
        	b.setRating(rating);
        	
        	
        	//int bid = Integer.parseInt(request.getParameter("bid"));
        	int fid = Integer.parseInt(request.getParameter("fid"));
        	int beid = Integer.parseInt(request.getParameter("bewertung"));
        	
        	//schreiben s = new schreiben();
        	
        	b.setBid(9);
        	b.setFid(fid);
        	b.setBeid(beid);
        	
        	ratingstore.addRating(b);
        	
        	request.getRequestDispatcher("/fahrt_bewerten.jsp").forward(request, response);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}*/
		
		
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
    	{
	    	Store fahrt = new Store();
			String textnachricht = request.getParameter("textnachricht");
			int rating = Integer.parseInt(request.getParameter("rating"));
			int fid = Integer.parseInt(request.getParameter("fid"));
			
			bewertung b = new bewertung();
			schreiben s = new schreiben();
			
			b.setTextnachricht(textnachricht);
			b.setRating(rating);
			s.setFahrt(fid);
			//b.setBeid(beid);
		
			fahrt.addRating(b);
			fahrt.schreiben(s);
			
			//response.sendRedirect("http://localhost:9035/view_course?fid="+fid+"&action=dri");	
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		
		
		
		/*
		try {
			Store ratingstore = new Store();
			
			
        	String textnachricht = request.getParameter("textnachricht");
        	//java.sql.Timestamp erstellungsdatum = java.sql.Timestamp.valueOf(request.getParameter("erstellungsdatum"));
        	int rating = Integer.parseInt(request.getParameter("rating"));
      
        	bewertung b = new bewertung();
        	
        	b.setTextnachricht(textnachricht);
        	//b.setErstellungsdatum("2022-02-10-10.00.00.000000");
        	b.setRating(rating);
        	
        	
        	//int bid = Integer.parseInt(request.getParameter("bid"));
        	//int fid = Integer.parseInt(request.getParameter("fid"));
        	//int beid = Integer.parseInt(request.getParameter("bewertung"));
        	
        	//schreiben s = new schreiben();
        	
        	//b.setBid(9);
        	//b.setFid(fid);
        	//b.setBeid(beid);
        	
        	ratingstore.addRating(b);
        	
        	
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		//response.sendRedirect("http://localhost:9035/view_main");
		
		//doGet(request, response); */
	}

}
