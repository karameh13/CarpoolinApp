<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Informationen</title>
    </head>
    
    <body>
        <h1> Informationen </h1>
        
		<form action="view_drive" method="get">
		
		<div id="lists">
		<c:forEach var="m" items="${fahrtlist}">		
			<div>
				<div id="inf">
				
				<h3><a id="links" action=${m.getFid()} href="view_drive?fid=${m.getFid()}&action=dri"><img src=${m.getIcon()} height=70 width=70 alt=${m.getTrname()} /> </a></h3>
					
				<div id="datei"><b>Anbieter: </b> <c:out value="${m.getAnbieterName()}" /> </div> <br>
				<div id="datei"><b>Von: </b> <c:out value="${m.getStartort()}" /></div> <br>
				<div id="datei"><b>Nach: </b> <c:out value="${m.getZielort()}" /></div> <br>
 				<div id="datei"><b>Fahrtdatumzeit: </b> <c:out value="${m.getFahrtdatumzeit()}" /></div> <br>
				<div id="datei"><b>Freie Plätze: </b> <c:out value="${m.getMaxPlaetze()}" /></div> <br>
				<div id="datei"><b>Fahrtkosten: </b> <c:out value="${m.getFahrtkosten()}" /></div> <br>
				<div id="datei"><b>Status: </b> <c:out value="${m.getStatus()}" /></div> <br>
				<div id="datei"><b>Beschreibung: </b> <a style="border: 2px solid black; width: 200px; padding: 10px; margin: 10px;"> <c:out value="${m.getBeschreibung()}" /></a> </div>
					<br> 
				</div>		
			</div>	
		</c:forEach>
		</div>
		
        <hr width="300" align="left">

        <h1>Aktionliste</h1>
        <form action="fahrt_reservieren" method="get">
        
        <!--
        <label for="anzPlaetze">Anzahl PlÃ¤tze fÃ¼r Reservierung: </label>
        <input type="number" id="anzPlaetze" name ="anzPlaetze" min="1" max="2"> <br><br>
        -->
     
        
        <c:forEach var="m" items="${fahrtlist}">	
        <h3><a id="links" action=${m.getFid()} href="fahrt_reservieren?fid=${m.getFid()}&action=res">
        <button type="button">Fahrt reservieren </button> </a></h3>
        </c:forEach>
        </form>
        
        
        <c:forEach var="m" items="${fahrtlist}">	
        <h3><a id="links" action=${m.getFid()} href="fahrt_loeschen?fid=${m.getFid()}&action=loesch">
        <button type="button">Fahrt löschen </button></a></h3>
        </c:forEach>
        

        <hr width="300" align="left">
        
        

        <h1>Bewertung</h1>
        
    	    
    	    <c:forEach var="c" items="${bewertunglist01}">	
				<h3> Durchschnittsrating:  <c:out value="${c.getAvgRating()}" /> </h3> 
			
			</c:forEach>
				<br><br>
        
        <div id="lists02">
		
		<c:forEach var="b" items="${bewertunglist}">	
			
			<div>
				<div id="bwr">
				<div id="bw"><b>Email: </b> <c:out value="${b.getEmail()}" /></div>
				<div id="bw"><b>Textnachricht: </b> <c:out value="${b.getTextnachricht()}" /></div>
					
				<div id="bw"><b>Rating: </b> <c:out value="${b.getRating()}" /></div>
					
				<br>
				</div>		
			</div>	
		</c:forEach>
		</div>
        
        
        
        <!--
        <#list fahrtlist as m>	
        <h3><a id="links" action=${m.getFid()} href="new_rating?fid=${m.getFid()}&action=rat">
        <button type="button">Fahrt bewerten </button></a></h3>
        </#list> -->
        
        <h3><a href="new_rating">
        <button type="button">Fahrt bewerten </button></a></h3>
        
        
        <a href="view_main">
        <button type="button">Zurück zur Hauptseite</button> </a>

        

	</form>
    </body>
</html>