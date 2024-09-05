<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hi!" %></h1>
<br/>
<h2>Enter your First Name and Last Name</h2>
<form action="/home" method="post">
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="ten"><br>
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="ho"><br><br>
  <input type="submit" value="Submit">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>