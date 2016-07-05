<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
<form action="Registration" method="post">
<h3> Add Below details: </h3>
<table>

<tr><th>Name:</th>
<th><input type="text" id="name" name="name" value="" placeholder="add name"></input></th>
</tr>

<tr><th>Email:</th>
<th><input type="text" id="email" name="email" value="" placeholder="add email"></input></th>
</tr>

<tr><th>Password:</th>
<th><input type="password" id="password" name="password" value="" placeholder="add password"></input></th>
</tr>

<tr><th>Motto:</th>
<th><input type="text" id="motto" name="motto" value="" placeholder="add motto"></input></th>
</tr>

</table>
<input type ="submit" name ="submit" id ="submit" value="Register"></input>

</form>

</body>
</html>