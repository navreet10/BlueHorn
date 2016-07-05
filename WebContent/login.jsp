<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="Login" method="post">
<h6><span style="color: #ff0000"> ${message} </span></h6>
<table>

<tr><th>Email:</th>
<th><input type="text" id="email" name="email" value="" placeholder="add email"></input></th>
</tr>

<tr><th>Password:</th>
<th><input type="password" id="password" name="password" value="" placeholder="write password"></input></th>
</tr>

</table>

<input type ="submit" name ="submit" id ="submit" value="Log In"></input>

<a href="registration.jsp">New User</a>

</form>

</body>
</html>