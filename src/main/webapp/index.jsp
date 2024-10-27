<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Identification</title>
</head>
<body>
<form action="TraiterLoginServlet" method="POST">
    <p>Login :<input type="text" name="login" maxlength="15" /></p>
    <p>Password : <input type="password" name="password" maxlength="6"
    /></p>
    <p><input type="submit" value="OK" /></p>
</form>
</body>
</html>