<html>
<head><title>Hello World</title>
 
<body>
  <form name="user" action="hello" method="get">
  
    Firstname: <input type="text" name="firstname" /> <br/>
    Lastname: <input type="text" name="lastname" /> <br/>
    <input type="submit" value="Save" />
  </form>
 
  <table class="datatable">
    <tr>
        <th>name</th>  <th>email</th>
    </tr>
    <#list users as user>
    <tr>
        <td> ${name} </td> 
    </tr>
    </#list>
  </table>
</body>
</html>