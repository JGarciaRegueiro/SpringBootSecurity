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
		<sec:authorize access="hasAnyAuthority('ROLE_ADMINISTRADOR')">
			<a href="/producto/alta" class="btn btn-primary btn-sm" >Nuevo Producto</a></td>
		</sec:authorize>
		<%List<Producto> listadoProductos = (List<Producto>)request.getAttribute("listadoProductos");%>
		<table class="table table-striped table-sm" >
			<th>Id</th><th>Descripcion</th><th>Opciones</th>
		
			<c:forEach var="ele" items="${listadoProductos }">
				<tr>
					<td>${ele.idProducto }</td>
					<td>${ele.descripción }</td>
					<td><a href="/detalleProducto/${ele.idProducto }" class="btn btn-success btn-sm">Ver detalle</a>
					<sec:authorize access="hasAnyAuthority('ROLE_ADMINISTRADOR')">
						<a href="/producto/editar/${ele.idProducto }" class="btn btn-success btn-sm">Modificar</a> 
						<a href="/producto/eliminar/${ele.idProducto }" class="btn btn-danger btn-sm">Borrar</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>