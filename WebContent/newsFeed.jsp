<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css" />
<title>NewsFeed</title>
</head>
<body style="background: #F5F1F1; background-color: #F5F1F1;">
<form action="NewsFeed" method="post">
<div class="container">
<jsp:include page="NavBar.jsp" />
 <div class="row">
  <div class="col-sm-6"><table class="table table-bordered">
  <tr><td><textarea id="post" name="post" placeholder="Say something.."></textarea> </td> 
  <td><input type="submit" id="submit" name="submit" value="Post"> </td> 
  </tr> </table>
  </div>
  <div class="col-sm-6"><table class="table table-bordered">
  <tr><td><input size="20" id="search" name="search" placeholder="Search something.."></textarea> </td> 
  <td><a href="<%=request.getContextPath()%>/Search"> Search</a></td> 
  </tr> </table>
  </div>
  <br> <br>
  <div class="col-sm-12"> <h2>Posts</h2>         
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Post date</th>
        <th>Post</th>
        <th>User</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="post" items="${posts}">
      <tr>
        <td><fmt:formatDate type="date" 
            value="${post.postdate}" /></td>
        <td><c:out value="${post.posttext}"></c:out></td>
        <td><c:out value="${post.bhuser.username}"></c:out></td>
      </tr>
      </c:forEach>
      
    </tbody>
  </table></div>											
</div>

</div>
</form>

</body>
</html>