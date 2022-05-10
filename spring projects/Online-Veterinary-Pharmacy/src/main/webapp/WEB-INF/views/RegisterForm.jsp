<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Veterinary Pharmacy | REGISTERATION FORM</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>
	<div class="wrapper">

		<div class="container">
			<div class="sec-form">
				<h2 class="cmn-ttl">Registeration Form</h2>
				<form:form action="saveUser" method="post" modelAttribute="user"
					cssClass="form">

					<form:hidden path="id" />
					<label for="username" class="form-cmn-txt"> Name</label>
					<form:input path="username" cssClass="input" />


					<label for="password" class="form-cmn-txt">Password</label>
					<form:input path="password" cssClass="input" />

					<label for="email" class="form-cmn-txt">Email</label>
					<form:input path="email" cssClass="input" />

					<form:button cssClass="btn">Register</form:button>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>