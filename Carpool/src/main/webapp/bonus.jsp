<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Bester Fahrer</title>
</head>

<body>
	
	
	
	<h2> offene Fahrten des besten Fahrers </h2> <br>
	<form action="bonus" method="get">
	<div id="lists">
		
		<c:forEach var="bl" items="${benutzerliste}">	
			<div>
				<div id="bid" name = "bid"><b>Fahrer-ID: </b>  <c:out value="${bl.getbid()}" /></div> <br>
				<div id="bemail"><b>Fahrer: </b> <c:out value="${bl.getemail()}" /></div> <br>
				<div id="avg"><b>Durchschnittsrating: </b><c:out value="${bl.getAvg()}" /></div>
					<br><br>
			</div>	
		</c:forEach>
		
			
		<c:forEach var="bf" items="${bid_f_liste}">	
			<div>
			
			<h3><a id="links" action=${bf.getFid()} href="view_drive?fid=${bf.getFid()}&action=dri"><img src=${bf.getIcon()} height=70 width=70 alt=${bf.getTrname()} /> </a></h3>
				    	
			
				<div id="fid"><b>Fahrt-ID: </b> <c:out value="${bf.getFid()}" /></div> <br>
				<div id="s_ort"><b>Startort: </b> <c:out value="${bf.getStartort()}" /></div>
				<div id="z_ort"><b>Zielort: </b> <c:out value="${bf.getZielort()}" /></div>
					<br><br>
			</div>	
		</c:forEach>
	</div>
	</form>
	
	<a href="view_main">
        <button type="button">ZurÃ¼ck zur Hauptseite</button> </a>
 
</body>
</html>