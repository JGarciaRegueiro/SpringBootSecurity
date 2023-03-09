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
		
		<h1>Ordenar por:</h1>
		<form>
			<select onchange="location = this.value;">
				<option value="">Ordenar por...</option>
				<option value="/categorias/precio/ascendente">Precio Ascendente</option>
				<option value="/categorias/precio/descendente">Precio Descendente</option>
				<option value="/categorias/stock">Volumen de stock</option>
			</select>
	    </form>
		
		<sec:authorize access="hasAnyAuthority('ROLE_ADMINISTRADOR')">
			<a href="/producto/alta">Nuevo Producto</a>
		</sec:authorize>
		<%List<Producto> listadoProductos = (List<Producto>)request.getAttribute("listadoProductos");%>
		<table>
			<th>Id</th><th>Descripcion</th><th>Precio</th><th>Volumen stock</th><th>Opciones</th>
		
			<c:forEach var="ele" items="${listadoProductos }">
				<tr>
					<td>${ele.idProducto }</td>
					<td>${ele.descripcion }</td>
					<td>${ele.precio }</td>
					<td>${ele.stock }</td>
					<td><a href="/producto/${ele.idProducto }">Ver detalle</a>
					<sec:authorize access="hasAnyAuthority('ROLE_ADMINISTRADOR')">
						<a href="/producto/editar/${ele.idProducto }">Modificar</a> 
						<a href="/producto/eliminar/${ele.idProducto }">Borrar</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>