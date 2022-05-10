<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Veterinary Pharmacy | ADD FORM</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>
	<div class="wrapper">

		<div class="container">
			<div class="sec-form">
				<h2 class="cmn-ttl">Medicine Add Form</h2>
				<form:form action="saveMedicine" method="post"
					modelAttribute="medicine" cssClass="form">

					<form:hidden path="id" />
					<label for="name" class="form-cmn-txt"> Name</label>
					<form:input path="name" cssClass="input" />


					<label for="category" class="form-cmn-txt">Category</label>
					<form:input path="category" cssClass="input" />

					<label for="description" class="form-cmn-txt">Description</label>
					<form:input path="description" cssClass="input" />

					<label for="price" class="form-cmn-txt">Price</label>
					<form:input path="price" cssClass="input" />


					<label for="status" class="form-cmn-txt">Status</label>
					<form:select path="status" cssClass="input">
						<form:option value="Available" label="Available" />
						<form:option value="Out Of Stock" label="Out Of Stock" />
						<form:option value="Low Stock" label="Low Stock" />
					</form:select>

					<label for="unit" class="form-cmn-txt">Unit In Stock</label>
					<form:input path="unit" cssClass="input" />


					<form:button cssClass="btn">Add</form:button>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>