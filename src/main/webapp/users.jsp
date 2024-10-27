<%@ page language="java" import="JavaBeans.UserBean"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Insert title here</title>
</head>
<body>
<%
    UserBean user = new UserBean();
    user = (UserBean)session.getAttribute("utilisateur");
    out.print("Votre Login est :"+user.getLogin()+"</br>");
    out.print("Votre Password est :"+user.getPassword()+"</br>");
%>
<a href="Modifier.jsp">Modifier</a>
</body>
</html>