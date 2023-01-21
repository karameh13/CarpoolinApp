package mainp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.fahrt;



@WebServlet("/Tests")
public class Tests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<fahrt> Fahrten = new ArrayList<fahrt>();
    
    public Tests() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionURL = "jdbc:mysql://localhost:3306/carpooldb?autoReconnect=true&useSSL=false&serverTimezone=Europe/Berlin";
			String userName = "root";
			String Password = "exodia";
			Connection myConnectionnection = DriverManager.getConnection(connectionURL,userName,Password);
			
			String query = "select startort,zielort from fahrt";
			
			PreparedStatement myStatement = myConnectionnection.prepareStatement(query);
			
			ResultSet myResult = myStatement.executeQuery();
			
			
			
			try
    		{
    			while(myResult.next()) {
    				myResult.getString(1);
    				myResult.getString(2);
    				
    				fahrt temp = new fahrt();
    				
    				temp.setStartort(myResult.getString(1));
    				temp.setZielort(myResult.getString(2));
    				
    				Fahrten.add(temp);
    			}
    			
    		} catch (SQLException e) {e.printStackTrace(); }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < Fahrten.size(); i++) {
			System.out.println(Fahrten.get(i).getStartort());	
		}
		request.setAttribute("f_list", Fahrten);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
