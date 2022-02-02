<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <h1>Fahrt erstellen</h1>
    von: <input type="text" name="von"> <br>
    bis: <input type="text" name="bis"> <br>
    anbieter: <input type="text" name="anbieter"> <br>
    Maximale Kapazität: <input type="text" name="max" > <br>
    Fahrkosten:<input type="text" name="kosten" > € <br>
    <div  >
      Tramsportmittle :
      Auto  <input type="radio" name="mittle" value="Auto">
      Bus  <input type="radio" name="mittle" value="Bus">
      Kleintransporter  <input type="radio" name="mittle" value="Kleintransporter">
    </div>
    <div> 
        Fahrtdatum
        <input type="date" id="datum" name="datum">
    </div>
    <input type="time" name="zeit"
    min="09:00" max="18:00" >
    <div> 
       Beschreibung <input type="textarea" name="beschreibung">
    </div>   
    <div>
     Erstellen : 
    <input type="submit" value="Submit">
    </div>
</body>
</html>