<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import="java.util.List"%>
<%@page import="com.grupo4.tienda.entities.Producto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="inicio.jsp"></jsp:include>
		<h1>Producto</h1>
		<%Producto producto = (Producto)request.getAttribute("producto");%>
			<table border="1">
				<tr>
					<th>Id</th>
					<th>Descripción</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Stock</th>
				</tr>
			<tr>
				<td><%= producto.getIdProducto()%></td>
				<td><%= producto.getDescripcion() %></td>
				<td><%= producto.getNombre() %></td>
				<td><%= producto.getPrecio() %></td>
				<td><%= producto.getStock() %></td>
			</tr>
	</table>
</body>
</html> 