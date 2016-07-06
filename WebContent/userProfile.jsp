<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
<form action="EditUserProfile" method="post">
<h6><span style="color: #ff0000"> ${message} </span></h6>
<table>

<tr><th>Name:</th>
<th><input type="text" id="newName" name="newName" value="${name}" ></input></th>
</tr>

<tr><th>Email:</th>
<th><input type="text" id="newEmail" name="newEmail" value="${email}"  ></input></th>
</tr>

<tr><th>Password:</th>
<th><input type="text" id="newPassword" name="newPassword" value="${pwd}" ></input></th>
</tr>

<tr><th>Motto:</th>
<th><input type="text" id="newMotto" name="newMotto" value="${motto}"  ></input></th>
</tr>



</table>

<input type ="submit" name ="submit" id ="submit" value="Update"></input>



</form>

</body>
</html>