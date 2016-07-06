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
<title>Home</title>
</head>
<body style="background: #F5F1F1; background-color: #F5F1F1;">
<form action="HomePosts" method="post">
<div class="container">
<jsp:include page="NavBar.jsp" />
 <div class="row">
  <div class="col-sm-8"><input size="50" type="text" id="post" name="post" value=""
												placeholder="Say something"></input></div>
  <div class="col-sm-4"><input type="submit" id="submit" name="submit"
												value="Post"></input></div>
  <br> <br>
  <div class="col-sm-12"> <h2>Your Posts</h2>         
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Post date</th>
        <th>Post</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="post" items="${posts}">
      <tr>
        <td><fmt:formatDate type="date" 
            value="${post.postdate}" /></td>
        <td><c:out value="${post.posttext}"></c:out></td>
      </tr>
      </c:forEach>
      
    </tbody>
  </table></div>											
</div>

</div>
</form>
	
		<%-- <table width="100%" height="10%" border="0" align="center"
			style="margin-bottom: 0px; padding-bottom: 0px; bottom: 0px;">
			<tr style="margin-bottom: 0px; padding-bottom: 0px; bottom: 0px;">
				<td width="100%"
					style="margin-bottom: 0px; padding-bottom: 0px; bottom: 0px;">
					<jsp:include page="header.jsp" />
			</tr>

		</table>

		<table height="80%" cellPadding="0px" border="0" align="center"
			class="whiteBoxHome">
			<tr style="margin-top: 0px; padding-top: 0px; top: 0px;">
				<td valign="top" height="100%" align="center"
					style="margin-top: 0px; padding-top: 0px; top: 0px;">
					<div
						style="background: #F5F1F1; background-color: #F5F1F1; height: 400x; width: 1200px; overflow-x: hidden; margin-top: 0px; padding-top: 0px; ' overflow-y: hidden; padding-bottom: 10px;">


						<table cellspacing="7" width="100%"
							style="margin-top: 2px; padding-top: 2px; background: #F5F1F1; background-color: #F5F1F1; border-spacing: 7px; border-collapse: separate;">
							<tr class="whiteBoxHm"
								style="padding-top: 2px; padding-left: 2px; padding-right: 2px; padding-bottom: 2px; border-spacing: 20px">
								<!-- <td valign="top" width="50%" style="position: relative;z-index: 0;"><img src="assets/img/admin.jpg"
					 width="100%"></td> -->

								<td valign="middle" width="80%"><p class="heading">
										<table>
										<tr>
						<td> </td>
						<td><input type="submit" id="submit" name="submit"
												value="Post"></input> </td>
						</tr>
					</table>
									<b>Your Posts</b>
									
									 <font color="#000000" face="Arial" size="2%"><br> <!-- <div class="scrollBarConfrm1" id=resultTable width="100%"> -->
	                                
									<c:forEach var="post" items="${posts}">
										<span><c:out value="${post.postdate}"></c:out> </span>
										<table width="70%" align="center" border="1">
											<tr>
												<td><c:out value="${post.posttext}"></c:out></td>
											</tr>
										</table>
										<br>
									</c:forEach> <!-- </div> --> </font><br></td>
						</tr>

					</table>
					
				</div>
			</td>
		</tr>
	</table>

	<br>
	<table align="center" width="100%" height="10%" cellPadding="0"
			cellspacing="0"
			style="background: #F5F1F1; background-color: #F5F1F1; margin: 0; top: 0">
		<tr style="font-size: 11px;" valign="bottom" align="center">
			<td valign="middle" align="center">&nbsp;&nbsp;&nbsp;&copy;2016
				| infosys All Rights Reserved</td>
		</tr>
	</table>


</form> --%>

	<%-- <h1>Welcome ${userName}</h1>
<h3>${message}</h3>
An ordered list:
<ul>
 <li>One fish</li>
 <li>two fish</li>
</ul>
<p> My first para</p>
<p> My second para</p>
<p> <a href="">Hello</a></p>
<span> ${table} </span>
<table border="1">
<br>
<tr> <th>Origin</th> <th>Food</th> <th>Rating</th>
</tr>

<tr><td>Balt</td> <td>carabes</td> <td>9</td> 
</tr>

<tr><td>Shoe</td> <td>carabes</td> <td>10</td> 
</tr>

<tr><td>BaBal</td> <td>Old</td> <td>11</td> 
</tr>

<tr><td>Miami</td> <td>Magoes</td> <td>12</td> 
</tr> </table>--%>

	
</body>
</html>