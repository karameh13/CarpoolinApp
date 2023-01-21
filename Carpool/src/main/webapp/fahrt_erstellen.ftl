<html>
    <head>
        <title> Fahrt erstellen</title>
    </head>
    <body>
        <h1> Fahrt erstellen</h1>
        <form action="fahrt_erstellen" method="post">
            <label for="startort">Von: </label>
            <input type="text" id="inp01" name="startort"> <br><br> 

            <label for="zielort">Bis: </label>
            <input type="text" id="inp01" name="zielort"> <br><br>

            <label for="maxPlaetze">Maximale Kapazität: </label>
            <input type="number" id="inp01" name="maxPlaetze" min="1" max="10"> <br><br>

            <label for="fahrtkosten">Fahrt Kosten: </label>
            <input type="text" id="inp01" name="fahrtkosten" size="8"> $ <br><br>


            <label for="transportmittel">Transportmittel: </label>
            
            <input type="radio" value="1" id="inp01" name="transportmittel">
            <label for="auto">
			<img src="auto.png" height=70 width=70 alt="Auto" align="middle" />
			</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
            <input type="radio" value="2" id="inp01" name="transportmittel">
            <label for="bus">
            <img src="bus.png" height=70 width=70 alt="Bus" align="middle"/>
            </label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <input type="radio" value="3" id="inp01" name="transportmittel">
            <label for="kleintransporter">
            <img src="kleintransporter.png" height=70 width=70 alt="Kleintransporter" align="middle" />
            </label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <br><br>

            
            <label for="fahrdatum">Fahrdatum:</label>
            <input type="date" id="inp01" name="fahrtdatumzeit" >

            <input type="time" id="inp01" name="fahrtdatumzeit" >  

            <br><br> 

            <label for="beschreibung">Beschreibung: </label>
            <textarea type="text" id="inp01" name="beschreibung" maxlength="50" style="vertical-align: middle;" rows=4> 
            </textarea> <br><br>
            
            <input name="action" type="hidden" value="fahrt_erstellen"> <br>
			
            <button type="submit">Erstellen</button>
            
             &nbsp;&nbsp;&nbsp;
             
            <a href="view_main">
       		<button type="button">Abbrechen</button> </a>
       		
        </form>
        
    </body>
</html>