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
			<!--  <a href="${pageContext.request.contextPath}/login"
				class="cmn-btn">Login</a> <a
				href="${pageContext.request.contextPath}/rigister"
				class="cmn-btn">Register</a> -->
				
				
				<c:if test="${pageContext.request.userPrincipal.name != null}">
        Hello
           <a href="#">
                ${pageContext.request.userPrincipal.name} </a>
         &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">Logout</a>
 
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
            |
            <a href="${pageContext.request.contextPath}/register">Register</a>
        </c:if>
			
				
		
		</div>
	</div>
</body>
</html>
