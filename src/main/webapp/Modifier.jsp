<%@ page language="java" import="JavaBeans.UserBean"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Modification</title>
</head>
<body>
<%
    UserBean user = new UserBean();
    user = (UserBean)session.getAttribute("utilisateur"); %>

Faculté des Sciences et Techniques de Tanger JEE

<form action="TraiterLoginServlet" method="POST">
    <p>Login :<input type="text" name="login" value="<%=user.getLogin()
%> " maxlength="15" /></p>
    <p>Password : <input type="text" name="password"
                         value="<%=user.getPassword() %> " maxlength="15" /></p>
    <p><input type="submit" value="OK" /></p>
    <%
        String val="modification";
        session.setAttribute("page",val);
    %>
</form>
</body>