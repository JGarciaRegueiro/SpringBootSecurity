<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="inicio.jsp"></jsp:include>
		<h1>Producto</h1>
		${productos }
		<%List<Producto> productos = (List<Producto>)request.getAttribute("productos");%>
		<c:forEach var="ele" items="${productos }">
		<p>${ele }
	</body>
</html>