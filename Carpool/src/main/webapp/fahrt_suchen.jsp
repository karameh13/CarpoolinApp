<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Fahrt suchen</title>
    </head>
    <body>
        <h1>Fahrt suchen</h1>
        <form action="fahrt_suchen" method="post">
        
        <label for="startort">Start: </label>
        <input type="text" id="startort" name="startort">  &nbsp;
        &nbsp;&nbsp;&nbsp;


		
        <label for="zielort">Ziel: </label>
        <input type="text" id="zielort" name="zielort" > 
        <br><br>
		
		
		
		<input name="action" type="hidden" value="fahrt_suchen"> <br>
		<button type="submit">Suche</button>
		
		
        <hr width="300" align="left">  
        
        </form>
        
        
        <h1>Suchergebnisse</h1>
        
        <form action="fahrt_suchen" method="get">
        
        <div id="lists02">
		<c:forEach var="m" items="${fahrtlistsuche}">		
			<div>
				<div id="ofn">
				
					
					<h3><a id="links" action=${m.getFid()} href="view_drive?fid=${m.getFid()}&action=such"><img src=${m.getIcon()} height=70 width=70 alt=${m.getTrname()} /> </a></h3>
					
					<div id="von"><b>Von: </b> <c:out value="${m.getStartort()}" /></div>
					<div id="zielort"><b>Nach: </b> <c:out value="${m.getZielort()}" /></div>
					<div id="fahrt_kosten"><b>Fahrtkosten: </b> <c:out value="${m.getFahrtkosten()}" /> </div>
					<br/>
					
				</div>		
			</div>	
		</c:forEach>
		</div>
        
        
        
        </form>
        
        
		<br><br>
        
        <a href="view_main">
        <button type="button">Zurück zur Hauptseite</button> </a>
        
    </body>
</html>