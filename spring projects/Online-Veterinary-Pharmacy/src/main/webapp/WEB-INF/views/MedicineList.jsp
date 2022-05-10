<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Veterinary Pharmacy | Medicine List</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>
	<div class="wrapper">
		<div class="sec-list">
			<div class="container">
				<h2 class="cmn-ttl">Medicine List</h2>
				<table class="tbl-student">
					<tr>
						<th>Name</th>
						<th>Category</th>
						<th>Description</th>
						<th>Price</th>
						<th>Status</th>
						<th>Unit</th>
						<th>Action</th>
					</tr>

					<c:forEach var="tempMedicine" items="${medicines}">

						<c:url var="updateLink" value="/medicine/updateForm">
							<c:param name="medicineId" value="${tempMedicine.id}" />
						</c:url>

						<c:url var="deleteLink" value="/medicine/delete">
							<c:param name="medicineId" value="${tempMedicine.id}" />
						</c:url>

						<tr>
							<td>${tempMedicine.name}</td>
							<td>${tempMedicine.category}</td>
							<td>${tempMedicine.description}</td>
							<td>${tempMedicine.price}</td>
							<td>${tempMedicine.status}</td>
							<td>${tempMedicine.unit}</td>
							<td><a href="${updateLink}" class="cmn-link">Update</a> <a
								href="${deleteLink}" class="cmn-link"
								onclick="if (!(confirm('Are you sure you want to delete this item?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>

				</table>
				<br /> <br /> <input type="button" value="Add Medicine"
					class="add-btn"
					onclick="window.location.href='showForm'; return false;" />
			</div>
		</div>
	</div>
</body>
</html>