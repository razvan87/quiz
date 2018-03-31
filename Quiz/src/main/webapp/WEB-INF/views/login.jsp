<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yahoo from JSP !!</title>
</head>
<body>
<p>${mesaj}</p>
<form action="/login.do" method="post">
Enter your name <input type="text" name="name"/> 
				<input type="password" name="pass"/>
				<input type="submit" value="LOGIN"/>
</form>
</body>
</html>