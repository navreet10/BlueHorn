<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
	<form action="EditUserProfile" method="post">
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
								<div align="left">Edit user</div>

							</div>
							<div class="panel-body">
								<table>

									<tr>
										<th>Name:</th>
										<th><input type="text" id="newName" name="newName"
											value="${name}"></input></th>
									</tr>

									<tr>
										<th>Email:</th>
										<th><input type="text" id="newEmail" name="newEmail"
											value="${email}"></input></th>
									</tr>

									<tr>
										<th>Password:</th>
										<th><input type="text" id="newPassword"
											name="newPassword" value="${pwd}"></input></th>
									</tr>

									<tr>
										<th>Motto:</th>
										<th><input type="text" id="newMotto" name="newMotto"
											value="${motto}"></input></th>
									</tr>



								</table>
							</div>
							<div class="panel-footer">
								<div id="text"></div>
								<div align="right">
									<input type="submit" name="submit" id="submit" value="Update"></input>
								</div>
							</div>
						</div>



					</div>
					<div class="col-sm-3"></div>
				</div>

			</div>

		</div>







	</form>

</body>
</html>