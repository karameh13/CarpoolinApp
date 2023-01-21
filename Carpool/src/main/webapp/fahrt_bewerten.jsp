<html>
    <head>
        <title>Fahrt bewerten</title>
    </head>
    <body>
    
   		<h1>Fahrt bewerten</h1>
  	    <form action="new_rating" method="post"> <br>
  	    
  	    <label for="fid">fid: </label>
        <input type="number" id="bew" name="fid"> <br><br>
  	    
        
        <label for="bewertungstext">Bewertungstext: </label>
        <textarea type="text" id="bew" name="textnachricht" maxlength="50"> 
        </textarea>
        
        <br><br>
        
        <label for="bewertungsrating">Bewertungsrating: </label>
        <input type="number" id="bew" name="rating" min="1" max="5"> <br><br>
        
        
        <input name="action" type="hidden" value="new_rating"> <br>
		<button type="submit">Bewerten</button>
            
        &nbsp;&nbsp;&nbsp;
        <a href="view_main">
       	<button type="button">Abbrechen</button> </a>
        
		</form>
    </body>
</html>