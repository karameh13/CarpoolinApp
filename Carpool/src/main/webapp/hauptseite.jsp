<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>view_main</title>
</head>

<body>
	<form action="view_main" method="get">
 	<div id="wrapper">
		<div id="head"><h1>carSharer</h1></div>
	<br/><br/>
	<hr width="300" align="left">
	
	<div id="resv"><h2> meine reservierten Fahrten </h2></div> <br>
	<div id="lists">
	<c:forEach var="m" items="${fahrtlist01}">	
			<div>
				<div id="res">
				
				
				<h3><a id="links" action=${m.getFid()} href="view_drive?fid=${m.getFid()}&action=dri"><img src=${m.getIcon()} height=70 width=70 alt=${m.getTrname()} /> </a></h3>
				<div id="von"><b>Von: </b> <c:out value="${m.getStartort()}" /> </div>
				<div id="zielort"><b>Nach: </b> <c:out value="${m.getZielort()}" /> </div>
				<div id="status"><b>Status: </b> <c:out value="${m.getStatus()}" /> </div>
				<br/>
				</div>		
			</div>	
		</c:forEach>
	</div>
	<hr width="300" align="left">
	
			<div id="offene"><h2> offene Fahrten </h2></div> <br>
	<div id="lists02">	
		<c:forEach var="m" items="${fahrtlist02}">	
			<div>
				<div id="ofn">
				
				
				<h3><a id="links" action=${m.getFid()} href="view_drive?fid=${m.getFid()}&action=dri"><img src=${m.getIcon()} height=70 width=70 alt=${m.getTrname()} /> </a></h3>
				
				<div id="von"><b>Von: </b><c:out value="${m.getStartort()}" /> </div>
				<div id="zielort"><b>Nach: </b> <c:out value="${m.getZielort()}" /></div>
				<div id="freie_plaetze"><b>Freie Plätze: </b><c:out value="${m.getMaxPlaetze()}" /></div>
				<div id="fahrt_kosten"><b>Fahrtkosten: </b><c:out value="${m.getFahrtkosten()}" /></div>
				<br/> <br>
				<hr width="300" align="left">
					
				</div>		
			</div>	
		</c:forEach>
	</div>
	
	<br><br>
	
	<a href="fahrt_erstellen">
		<button type="button">Fahrt erstellen</button> </a> <br><br>
		
	<a href="fahrt_suchen">
        <button type="button">Fahrt suchen</button> </a> <br><br>
        
      <a href="bonus">
		<button type="button">Fahrten besten Fahrers</button> </a> <br><br>
	  
  </div>
  
  </form>
  
  
</body>
</html>