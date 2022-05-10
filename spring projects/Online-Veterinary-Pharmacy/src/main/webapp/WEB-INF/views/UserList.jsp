<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Veterinary Pharmacy  | User List</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>
	<div class="wrapper">
		<div class="sec-list">
			<div class="container">
				<h2 class="cmn-ttl">User List</h2>
				<table class="tbl-student">
					<tr>
						<th>Name</th>
						<th>Password</th>
						<th>Email</th>
						
					</tr>

					<c:forEach var="tempUser" items="${users}">

						

						<tr>
							<td>${tempUser.username}</td>
							<td>${tempUser.password}</td>
							<td>${tempUser.email}</td>
							
							
						</tr>
					</c:forEach>

				</table>
				
			</div>
		</div>
	</div>
</body>
</html>