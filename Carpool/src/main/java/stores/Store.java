package stores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import domain.benutzer;
import domain.reservieren;
import domain.bewertung;
import domain.schreiben;
import domain.fahrt;


@WebServlet("/Store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection myConnection = null;
    private boolean complete;
    
    public Store() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionURL = "jdbc:mysql://localhost:3306/carpooldb?autoReconnect=true&useSSL=false&serverTimezone=Europe/Berlin";
			String userName = "root";
			String Password = "exodia";
			myConnection = DriverManager.getConnection(connectionURL,userName,Password);
			myConnection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
        //super();
    }
    
    public ArrayList<fahrt> getAlleFahrten()  
    {
    	
    	ArrayList<fahrt> Fahrten = new ArrayList<fahrt>();
    	
    	String Query = "select * from ((select f.startort, f.zielort, f.fahrtkosten, "
    			+ " (f.maxPlaetze - x.anz) as anpl, f.fid as faid, "
    			+ " f.transportmittel, tr.icon, tr.name from carpooldb.fahrt as f, "
    			+ " carpooldb.transportmittel as tr, (select count(anzPlaetze) as anz, fahrt "
    			+ " from carpooldb.reservieren group by fahrt) as x "
    			+ " where x.fahrt = f.fid and f.transportmittel = tr.tid ) "
    			+ " union (SELECT fa.startort, fa.zielort, fa.fahrtkosten, "
    			+ " fa.maxPlaetze, fa.fid, fa.transportmittel, tr.icon, tr.name "
    			+ " from carpooldb.fahrt as fa, carpooldb.transportmittel as tr "
    			+ " where fa.transportmittel = tr.tid and fa.fid not in(select f.fid "
    			+ " from carpooldb.fahrt "
    			+ " as f, (select count(anzPlaetze) as anz, fahrt "
    			+ " from carpooldb.reservieren group by fahrt) as x "
    			+ " where x.fahrt = f.fid))) tp where anpl >= 1 order by faid ";
    	
    	PreparedStatement myPreparedStatement = null;
    	
		try{
			myPreparedStatement = myConnection.prepareStatement(Query);
			ResultSet myResultSet = myPreparedStatement.executeQuery();
	    		try
	    		{
	    			while(myResultSet.next()) {
	    				myResultSet.getString(1);
	    				myResultSet.getString(2);
	    				myResultSet.getDouble(3);
	    				myResultSet.getInt(4);
	    				myResultSet.getInt(5);
	    				myResultSet.getInt(6);
	    				myResultSet.getString(7);
	    				myResultSet.getString(8);
	    				
	    				fahrt temp = new fahrt();
	    				
	    				temp.setStartort(myResultSet.getString(1));
	    				temp.setZielort(myResultSet.getString(2));
	    				temp.setFahrtkosten(myResultSet.getDouble(3));
	    				temp.setMaxPlaetze(myResultSet.getInt(4));
	    				temp.setFid(myResultSet.getInt(5));
	    				temp.setTransportmittel(myResultSet.getInt(6));
	    				temp.setIcon(myResultSet.getString(7));
	    				temp.setTrname(myResultSet.getString(8));
	    				
	    				Fahrten.add(temp);
	    			}
	    			
	    		} catch (SQLException e) {e.printStackTrace(); }
	    		
	    		/*finally {
	    			if (myPreparedStatement != null) {
	    		        try {
	    		            myPreparedStatement.close();
	    		        } catch (SQLException e) {e.printStackTrace(); }
	    		    }
	    			if (myResultSet != null) {
	    		        try {
	    		            myResultSet.close();
	    		        } catch (SQLException e) { e.printStackTrace();}
	    		    }
	    			if (myConnection != null) {
	    		        try {
	    		            myConnection.close();
	    		        } catch (SQLException e) {e.printStackTrace(); }
	    		    }
				}*/
	    		
	    		
    		}
		
    	catch(Exception e) {
    		e.printStackTrace();
    		}
		    
			
    	return Fahrten;
    }
    
    public ArrayList<fahrt> getResFahrten()  
    {
    	
    	ArrayList<fahrt> ResFahrten = new ArrayList<fahrt>();
    	String Query="SELECT f.startort, f.zielort, f.status, f.transportmittel, "
    			+ " tr.icon, tr.name, f.fid "
    			+ " from carpooldb.fahrt f, carpooldb.reservieren r, carpooldb.transportmittel tr "
    			+ "WHERE r.fahrt = f.fid and f.transportmittel = tr.tid and r.kunde=9 ";
		
    	PreparedStatement ps = null;
		try
    	{	
			ps = myConnection.prepareStatement(Query);
			ResultSet rs=ps.executeQuery();
    		try
    		{
    			while(rs.next())
    			{
    				rs.getString(1);
    				rs.getString(2);
    				rs.getString(3);
    				rs.getInt(4);
    				rs.getString(5);
    				rs.getString(6);
    				rs.getInt(7);
    				
    				fahrt temp = new fahrt();
    				
    				temp.setStartort(rs.getString(1));
    				temp.setZielort(rs.getString(2));
    				temp.setStatus(rs.getString(3));
    				temp.setTransportmittel(rs.getInt(4));
    				temp.setIcon(rs.getString(5));
    				temp.setTrname(rs.getString(6));
    				temp.setFid(rs.getInt(7));
    				
    				ResFahrten.add(temp);
    				
    			}
    		}  catch (SQLException e) {e.printStackTrace(); }
    		/*finally {
    			if (ps != null) {
    		        try {
    		            ps.close();
    		        } catch (SQLException e) {e.printStackTrace(); }
    		    }
    			if (rs != null) {
    		        try {
    		            rs.close();
    		        } catch (SQLException e) {e.printStackTrace(); }
    		    }
    			if (myConnection != null) {
    		        try {
    		        	myConnection.close();
    		        } catch (SQLException e) {e.printStackTrace(); }
    		    }
				
			}*/
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		
		
    	return ResFahrten;
    }
    
    public ArrayList<fahrt> getFahrt(int fid)  
    {
    	ArrayList<fahrt> fahrtInfo = new ArrayList<fahrt>();
    	
    	 String sql1 = " select * from ((select f.fid as f1, b.email, f.startort, "
    	 		+ " f.zielort, (f.maxPlaetze - x.anz) as anpl, "
    	 		+ " f.fahrtkosten, f.status, f.beschreibung as beschreibung, "
    	 		+ " f.fahrtdatumzeit, f.transportmittel , tr.name, tr.icon "
    	 		+ " from carpooldb.fahrt f, carpooldb.benutzer b, carpooldb.transportmittel tr, (select count(anzPlaetze) as anz, fahrt "
    	 		+ " from carpooldb.reservieren group by fahrt) as x "
    	 		+ " where x.fahrt = f.fid and b.bid = f.anbieter and tr.tid = f.transportmittel) union (select f.fid as f2, b.email, f.startort, f.zielort, f.maxPlaetze, "
    	 		+ "	f.fahrtkosten, f.status, f.beschreibung, f.fahrtdatumzeit, f.transportmittel , tr.name, tr.icon "
    	 		+ " from carpooldb.fahrt f, carpooldb.benutzer b, carpooldb.transportmittel tr "
    	 		+ "	where b.bid = f.anbieter and tr.tid = f.transportmittel)) as dt where f1=? LIMIT 1 ";


    	
    	 PreparedStatement ps = null;
    	   
    	try
    	{	
    		ps = myConnection.prepareStatement(sql1);
    		ps.setInt(1,fid);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		try
    		{
    			while(rs.next())
    			{
	    			rs.getString(2);
					rs.getString(3);
					rs.getString(4);
					rs.getInt(5);
					rs.getDouble(6);
					rs.getString(7);
					rs.getString(8);
					rs.getString(9);
					rs.getInt(10);
					rs.getString(11);
					rs.getString(12);
					
					rs.getInt(1);
					
					fahrt temp = new fahrt();
					
					temp.setAnbieterName(rs.getString(2));
					temp.setStartort(rs.getString(3));
					temp.setZielort(rs.getString(4));
					temp.setMaxPlaetze(rs.getInt(5));
					temp.setFahrtkosten(rs.getDouble(6));
					temp.setStatus(rs.getString(7));
					
					if(rs.getString(8) != null)
						temp.setBeschreibung(rs.getString(8));
					else
						temp.setBeschreibung("Keine Beschreibung");
					
					temp.setFahrtdatumzeit(rs.getString(9));
					temp.setTransportmittel(rs.getInt(10));
					temp.setTrname(rs.getString(11));
					temp.setIcon(rs.getString(12));
					
					temp.setFid(rs.getInt(1));
					
					
					fahrtInfo.add(temp);
    			}
    		} catch (SQLException e) { e.printStackTrace(); }
    		
    		/*finally {
    		    if (rs != null) {
    		        try {
    		            rs.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    if (ps != null) {
    		        try {
    		            ps.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    
    		    if (myConnection != null) {
    		        try {
    		            myConnection.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		}*/
    		
    	}
    	
    	catch(Exception e){
    		e.printStackTrace();
    		}
    	
    	
    	
    	return fahrtInfo;
    }
	
	public ArrayList<fahrt> getFahrt_suchen(String von, String nach)  
    {
    	ArrayList<fahrt> fahrtSuche = new ArrayList<fahrt>();
    	
    	String Query="select f.startort, f.zielort, f.fahrtkosten, f.fid, f.transportmittel, tr.icon, tr.name "
    			+ " from carpooldb.fahrt f, carpooldb.transportmittel tr "
    			+ " where startort like ? and zielort like ? and f.transportmittel = tr.tid ";
    	
    	PreparedStatement ps = null;
    	
    	try
    	{	
    		ps = myConnection.prepareStatement(Query);
    		ps.setString(1, "%"+von+"%");
    		ps.setString(2, "%"+nach+"%");
    		ResultSet rs = ps.executeQuery();
    		try {
    			while(rs.next())
    			{
	    			
    				
					rs.getDouble(3);
					rs.getInt(4);
					rs.getInt(5);
					rs.getString(6);
					rs.getString(7);
					
					rs.getString(1);
    				rs.getString(2);
    				
					fahrt temp = new fahrt();

					temp.setFahrtkosten(rs.getDouble(3));
					temp.setFid(rs.getInt(4));
					temp.setTransportmittel(rs.getInt(5));
					temp.setIcon(rs.getString(6));
					temp.setTrname(rs.getString(7));
					
					temp.setStartort(rs.getString(1));
					temp.setZielort(rs.getString(2));
					
					fahrtSuche.add(temp);
    			}
    		}	catch (SQLException e) {e.printStackTrace();}
    		
    		/*finally {
    		    if (rs != null) {
    		        try {
    		            rs.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    if (ps != null) {
    		        try {
    		            ps.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    
    		    if (myConnection != null) {
    		        try {
    		            myConnection.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		}*/
    	
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		}
    	
    	return fahrtSuche;
    }
	
	public ArrayList<bewertung> getBewertung(int fid)  
    {
    	ArrayList<bewertung> bewertungInfo = new ArrayList<bewertung>();
    	
    	String Query="select f.fid, ben.bid, ben.email, bew.textnachricht, bew.rating "
    			+ " from carpooldb.fahrt f, carpooldb.benutzer ben, carpooldb.bewertung bew, "
    			+ "carpooldb.schreiben s where f.fid=? and ben.bid=s.benutzer and bew.beid = s.bewertung and f.fid = s.fahrt";
    	   
    	try(PreparedStatement ps = myConnection.prepareStatement(Query))
    	{	
    		ps.setInt(1,fid);
    		ResultSet rs = ps.executeQuery();
    		try {
    			while(rs.next())
    			{
    				rs.getInt(2);
	    			rs.getString(3);
					rs.getString(4);
					rs.getInt(5);
					
					rs.getInt(1);
					
					bewertung temp = new bewertung();
					temp.setBeid(rs.getInt(2));
					temp.setEmail(rs.getString(3));
					temp.setTextnachricht(rs.getString(4));
					temp.setRating(rs.getInt(5));
					
					temp.setFid(rs.getInt(1));
					
					bewertungInfo.add(temp);
    			}
    		}	catch (SQLException e) {e.printStackTrace();}
    		
    		/*finally {
    		    if (rs != null) {
    		        try {
    		            rs.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    if (ps != null) {
    		        try {
    		            ps.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    
    		    if (myConnection != null) {
    		        try {
    		            myConnection.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		}*/
    	}
    	
    	catch(Exception e){
    		e.printStackTrace();
    		}
    	
    	return bewertungInfo;
    }
	
	public ArrayList<bewertung> getAvgBewertung(int fid)  
    {
    	ArrayList<bewertung> bewertungAvg = new ArrayList<bewertung>();
    	
    	String avgQuery="select avg(bew.rating) "
    			+ " from carpooldb.bewertung bew, carpooldb.schreiben s where s.fahrt=? and bew.beid = s.bewertung";
    	   
    	try(PreparedStatement ps = myConnection.prepareStatement(avgQuery))
    	{	
    		ps.setInt(1,fid);
    		ResultSet rs = ps.executeQuery();
    		try {
    			while(rs.next())
    			{
    				rs.getDouble(1);
					bewertung temp = new bewertung();
					temp.setAvgRating(rs.getDouble(1));
					temp.setFid(fid);
					
					bewertungAvg.add(temp);
    			}
    		}  catch (SQLException e) {e.printStackTrace();}
    		
    		/*finally {
    		    if (rs != null) {
    		        try {
    		            rs.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    if (ps != null) {
    		        try {
    		            ps.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    
    		    if (myConnection != null) {
    		        try {
    		            myConnection.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		}*/
    	}
    	
    	catch(Exception e){
    		e.printStackTrace();
    		}
    	
    	return bewertungAvg;
    }
	
	public void addFahrt(fahrt f)
    {
		String ins_sql = "INSERT INTO carpooldb.fahrt(startort, zielort, fahrtdatumzeit, maxPlaetze, fahrtkosten, anbieter, transportmittel, beschreibung) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try
    	{
    		ps = myConnection.prepareStatement(ins_sql);
    		
    		ps.setString(1,f.getStartort());
    		ps.setString(2,f.getZielort());
        	ps.setString(3,f.getFahrtdatumzeit());
    		ps.setInt(4,f.getMaxPlaetze());
    		ps.setDouble(5,f.getFahrtkosten());
    		ps.setInt(6,f.getAnbieter());
    		ps.setInt(7,f.getTransportmittel());
    		ps.setString(8,f.getBeschreibung());
    		
    		ps.executeUpdate();
    			
    	}
    	
    	catch(SQLException e)
    	{
    		try{
            	myConnection.rollback();
            }catch(SQLException e2){
            	
            } e.printStackTrace();
    	}
		
    }
	
	public void addRating(bewertung b) throws SQLException
    {
		
		String sql1 = "INSERT INTO carpooldb.bewertung (textnachricht, rating) VALUES (?,?)";
		
    	try(PreparedStatement ps1 = myConnection.prepareStatement(sql1))
    	{	
    		ps1.setString(1, b.getTextnachricht());
    		ps1.setInt(1, b.getRating());
    		
    		ps1.executeUpdate();
    		
    		
    	}
    	catch(Exception e) 
    	{
    		myConnection.rollback();
    		e.printStackTrace();
    		}
    }
	
	public void schreiben (schreiben b) throws SQLException {
		String sql2 = "INSERT INTO carpooldb.schreiben (benutzer, fahrt, bewertung)  VALUES (?,?,?)";
		
		try(PreparedStatement ps2 = myConnection.prepareStatement(sql2)) {
			ps2.setInt(1,b.getBenutzer());
			ps2.setInt(2,b.getFahrt());
			
			int beid = 0;
			ResultSet rs = ps2.getGeneratedKeys();
			if(rs.next()) {
				beid = rs.getInt(beid);
				ps2.setInt(3,b.getBewertung());
			}
			
			ps2.executeUpdate();
			
		} catch (Exception e) {
			myConnection.rollback();
			e.printStackTrace();
		}
		
		
	}
	
	public void reservieren(reservieren r) { 
    		
 		String sql_insert="INSERT INTO carpooldb.reservieren (kunde, fahrt, anzPlaetze) VALUES (?,?,?)";
 		PreparedStatement ps = null;
 		
   		try {
   			
   			ps = myConnection.prepareStatement(sql_insert);
   			
   			ps.setInt(1,r.getKunde());
    		ps.setInt(2,r.getFahrt());
   			ps.setInt(3,r.getAnzPlaetze());
    		
   			ps.executeUpdate();
    			
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
   				
    }

	public ArrayList<benutzer> getBesterFahrer(){
		
		ArrayList<benutzer> benutzerInfo = new ArrayList<benutzer>();
		
		String sql = "select avg(bw.rating) as av, bn.email, bn.bid from carpooldb.bewertung bw"
				+ " join carpooldb.schreiben s on s.bewertung = bw.beid"
				+ " join carpooldb.fahrt f on s.fahrt = f.fid"
				+ " join carpooldb.benutzer bn on bn.bid = f.anbieter "
				+ " group by bn.email, bn.bid"
				+ " having avg(bw.rating) = (select max(x.av) from (select avg(bw.rating) as av, f.anbieter as id from carpooldb.bewertung bw"
				+ " join carpooldb.schreiben s on s.bewertung = bw.beid"
				+ " join carpooldb.fahrt f on s.fahrt = f.fid"
				+ " join carpooldb.benutzer bn on bn.bid = f.anbieter group by f.anbieter)x) ";
		
		PreparedStatement ps = null;
		
		try { 
			ps = myConnection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
    		try {
    			
    			while(rs.next())
    			{
    				rs.getDouble(1);
	    			rs.getString(2);
	    			rs.getInt(3);
					
					benutzer temp = new benutzer();
					
					temp.setAvg(rs.getDouble(1));
					temp.setemail(rs.getString(2));
					temp.setbid(rs.getInt(3));
					
					
					benutzerInfo.add(temp);
    			}
    		}	
    		catch (SQLException e) {e.printStackTrace();}
    		
    		/*finally {
    		    if (rs != null) {
    		        try {
    		            rs.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    if (ps != null) {
    		        try {
    		            ps.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    
    		    if (myConnection != null) {
    		        try {
    		            myConnection.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		}*/
    		
    	}
		
    	catch(Exception e){
    		e.printStackTrace();
    		}
    	
    	return benutzerInfo;
	}
	
	public ArrayList<fahrt> getBester_Fahrer(){
		
		ArrayList<fahrt> benutzerInfo = new ArrayList<fahrt>();
		
		
		String sql = " select t2.frid, t2.anb, t2.von, t2.nach, t1.av, t1.em, t2.ic, t2.nm "
				+ " from (select avg(bw.rating) as av, bn.email as em, bn.bid as benid from carpooldb.bewertung bw "
				+ " join carpooldb.schreiben s on s.bewertung = bw.beid "
				+ " join carpooldb.fahrt f on s.fahrt = f.fid "
				+ " join carpooldb.benutzer bn on bn.bid = f.anbieter  "
				+ " group by bn.email, bn.bid "
				+ " having avg(bw.rating) = (select max(x.av)  "
				+ " from (select avg(bw.rating) as av, f.anbieter as id from carpooldb.bewertung bw  "
				+ " join carpooldb.schreiben s on s.bewertung = bw.beid  "
				+ " join carpooldb.fahrt f on s.fahrt = f.fid  "
				+ " join carpooldb.benutzer bn on bn.bid = f.anbieter group by f.anbieter)x)) as t1,  "
				+ " (SELECT f.anbieter as anb, f.fid as frid, f.startort as von, f.zielort as nach, tr.icon as ic, tr.name as nm  "
				+ " from carpooldb.fahrt f, carpooldb.transportmittel tr where f.transportmittel = tr.tid) as t2  "
				+ " where t1.benid = t2.anb ";
		
		try(PreparedStatement ps = myConnection.prepareStatement(sql);) { 
			ResultSet rs = ps.executeQuery();
    		try {
    			while(rs.next())
    			{
    				rs.getInt(1);
    				rs.getInt(2);
	    			rs.getString(3);
	    			rs.getString(4);
	    			rs.getString(7);
	    			rs.getString(8);
					
					fahrt temp = new fahrt();
					
					temp.setFid(rs.getInt(1));
					temp.setAnbieter(rs.getInt(2));
					temp.setStartort(rs.getString(3));
					temp.setZielort(rs.getString(4));
					temp.setIcon(rs.getString(7));
					temp.setTrname(rs.getString(8));
					
					
					benutzerInfo.add(temp);
    			}
    		} catch(SQLException e) {e.printStackTrace();}	
    		
    		/*finally {
    		    if (rs != null) {
    		        try {
    		            rs.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    if (ps != null) {
    		        try {
    		            ps.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		    
    		    if (myConnection != null) {
    		        try {
    		            myConnection.close();
    		        } catch (SQLException e) {e.printStackTrace();}
    		    }
    		}*/
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		}
    	
    	return benutzerInfo;
	}
		
	public ArrayList<fahrt> getAlleFahrten_bid(int bid)  
    {
    	
    	ArrayList<fahrt> Fahrten = new ArrayList<fahrt>();
    	String Query="SELECT anbieter, fid, startort, zielort from carpooldb.fahrt where anbieter = ?";
    	
    	PreparedStatement ps = null;
    	
		try{
			ps = myConnection.prepareStatement(Query);
			ps.setInt(1,bid);
			ResultSet rs=ps.executeQuery();
	    		try
	    		{
	    			
	    			while(rs.next()) {
	    				
	    				rs.getInt(2);
	    				rs.getString(3);
	    				rs.getString(4);
	    				
	    				rs.getInt(1);
	    				
	    				fahrt temp = new fahrt();
	    				
	    				temp.setFid(rs.getInt(2));
	    				temp.setStartort(rs.getString(3));
	    				temp.setZielort(rs.getString(4));
	    				
	    				temp.setAnbieter(rs.getInt(1));
	    				Fahrten.add(temp);
	    			}
	    		} catch(SQLException e) {e.printStackTrace();}
	    		
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
			
    	return Fahrten;
    	
    }
	
	
    public void deleteFahrt(int fid) {
    		
    	try {
    		
    		String sqlQuery3="delete from carpooldb.schreiben where fahrt=?";
        	try(PreparedStatement ps3 = myConnection.prepareStatement(sqlQuery3)) {
        		ps3.setInt(1,fid); 			
       			ps3.executeUpdate();
        	}
    		
    		
    		String sqlQuery2="delete from carpooldb.reservieren where fahrt=?";
        	try(PreparedStatement ps2 = myConnection.prepareStatement(sqlQuery2)) {
        		ps2.setInt(1,fid); 			
       			ps2.executeUpdate();
        	}
    		
    		
    		String sqlQuery="delete from carpooldb.fahrt where fid=?";
        	try(PreparedStatement ps = myConnection.prepareStatement(sqlQuery)) {
        		ps.setInt(1,fid); 			
       			ps.executeUpdate();
        		
        	}
        	
			
		} catch(Exception e) {
    		try{
    			myConnection.rollback();
            }catch(SQLException e2){
            	
            } e.printStackTrace();
    	}
    	
    	
    
    } 

	public void complete() {
        complete = true;
    }
    
    public void close() throws IOException {
        if (myConnection != null) {
            try {
                if (complete) {
                	myConnection.commit();
                }
                else {
                	myConnection.rollback();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                	myConnection.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
  
      
}
