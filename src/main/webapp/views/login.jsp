<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please login JSP</title>
<style type="text/css">
label{
  text-align: left;
  color: SteelBlue;
  font-weight: bold;
  text-transform: uppercase;
  padding: 5px;
}
fieldset{
background : WhiteSmoke;
}
.form-actions{
 padding:3px 5px;
 color:#fff;
 font-family:'Helvetica Neue',sans-serif;
 font-size:12px;
}
</style>
</head>
<body>

	<div>
        <form action="login" method='POST'>               
            <fieldset>
                <legend>Please Login</legend>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>  
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>    
                <div class="form-actions">
                    <button type="submit" class="btn">Login</button>
                </div>
            </fieldset>
        </form>
    </div>
</body>
</body>
</html>