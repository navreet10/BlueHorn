<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BlueHorn</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <!-- <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">N</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li> -->
      
      <li><a href="<%=request.getContextPath()%>/NewsFeed">News Feed</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="false">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <%-- <c:if test=""> --%>
      <li><a href="<%=request.getContextPath()%>/Profile"><span class="glyphicon glyphicon-user"></span> Welcome ${userName} <img src="${gUrl}" alt="${user.username}"/></a></li>
      <li><a href="<%=request.getContextPath()%>/Logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
      <%-- </c:if> --%>
    </ul>
  </div>
</nav>
  


</body>
</html>
