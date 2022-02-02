<html>
<head><title>CarSharer</title>
<style type="text/css">
* {
   margin:0;
   padding:0;
}

body{
   text-align:center;
   background: #efe4bf none repeat scroll 0 0;
}

#wrapper{
   width:960px;
   margin:0 auto;
   text-align:left;
   background-color: #fff;
   border-radius: 0 0 10px 10px;
   padding: 20px;
   box-shadow: 1px -2px 14px rgba(0, 0, 0, 0.4);
}

#header{
 color: #fff;
 background-color: #2c5b9c;
 height: 3.5em;
 padding: 1em 0em 1em 1em;
 
}

#site{
    background-color: #fff;
    padding: 20px 0px 0px 0px;
}
.centerBlock{
	margin:0 auto;
}
</style>

<body>

	    <div id="wrapper">
		<div id="header">
		<h1> CarSharer Website </h1>
		</div>

    <div>
        <list>
         Meine reservierten Fahrten
            <li>von: </li>
            <li>Nach: </li>
            <li>status:</li>
            <a href="/view_drive" class="button" target="_blank" >view_drive </a>
        </list>
        
    </div>
  
<br>
<br>
<br>  
  
    <div>
        <list>
        Offene Fahrten
            <li>von: </li>
            <li>Nach: </li>
            <li>status:</li>
            <li>Freie Plätze:</li>
            <li>Fahrkosten :</li>
        </list>
         <a href="/view_drive" class="button" target="_blank" >view_drive </a>
    </div>
<br>
<br>
<br>

<br>
<br>
<br>
<a href="/new_drive" class="button" target="_blank" >Fahrt erstellen </a>

</body>
<br>
<br>
<br>
DataBase Status :   ${db2exists}
</html>


