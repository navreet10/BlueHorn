<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="javascripts/home.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css" />
<title>Home</title>
</head>
<body>
	<form id="target" action="HomePosts" method="post">
		<div class="container">
			<br> <br>
			<jsp:include page="NavBar.jsp" />

			<div style="background-color: white;" class="panel-body">
				<div class="row">
					<div class="col-sm-2">
						<img src="${gBigUrl}" alt="${user.username}" />
					</div>
					<div class="col-sm-10"></div>

				</div>
				<c:set var="mes" scope="session" value="${message}" />
				<c:if test="${mes != null}">
					<div class="alert alert-success">
						<strong>${message}</strong> <span id="showSearchTerm"></span>
					</div>
				</c:if>
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div align="left">New Post</div>

							</div>
							<div class="panel-body">
								<textarea maxlength="141" id="post" name="post" placeholder="Say something"></textarea>
							</div>
							<div class="panel-footer">
							<div id="text"> </div> 
								<div align="right">
									<input type="submit" id="submit" name="submit" value="Post"></input>
								</div>
							</div>
						</div>



					</div>
					<div class="col-sm-3"></div>
				</div>
				<div class="row">
					<br> <br>
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<h2>Your Posts</h2>

						<div class="panel-group">
							<c:forEach var="post" items="${posts}">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<table width="100%">
											<tr>
												<td align="left">${post.bhuser.username}</td>
												<td align="right"><fmt:formatDate type="date"
														value="${post.postdate}" /></td>
											</tr>
										</table>

									</div>
									<div class="panel-body">
										<c:out value="${post.posttext}"></c:out>
									</div>
									<div class="panel-footer">
										<table width="100%">
											<tr>
												<td align="left"><a href="#"> <span
														class="glyphicon glyphicon-heart"></span>
												</a></td>
												<td align="right"><span
													class="glyphicon glyphicon-share-alt"></span> Reply</td>
											</tr>
										</table>

									</div>
								</div>
								<br><br>
							</c:forEach>


						</div>


					</div>
					<div class="col-sm-3"></div>
					
				</div>

			</div>
		</div>

	</form>

</body>
</html>