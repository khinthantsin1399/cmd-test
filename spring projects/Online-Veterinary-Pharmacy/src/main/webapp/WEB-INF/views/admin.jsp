<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
</head>
<body>
	<div class="sec-content">
		<div class="menu-btn">
			<a href="${pageContext.request.contextPath}/medicine/list"
				class="cmn-btn">Medicine List</a> <a
				href="${pageContext.request.contextPath}/medicine/showForm"
				class="cmn-btn">Medicine Add Form</a> 
				<a
				href="${pageContext.request.contextPath}/register"
				class="cmn-btn">Register</a>
				<a href="${pageContext.request.contextPath}/medicine/download">Download Excel Document</a>
		
		<form   action ="${pageContext.request.contextPath}/medicine/uploadExcel" method = "POST" enctype = "multipart/form-data">
      <br /> <br />
         Please select a file to upload : 
         <input type = "file" name = "file" value = "Browse File" accept=".xlsx" /> <br /> <br />
         Press here to upload the file :
         <input type = "submit" value = "upload" /> <br /> <br /> 
       
         </form>
		
		</div>
	</div>
</body>
</html>
