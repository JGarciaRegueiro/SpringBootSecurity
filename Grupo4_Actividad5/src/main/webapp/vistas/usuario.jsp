<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import="java.util.List"%>
<%@page import="com.grupo4.tienda.entities.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="inicio.jsp"></jsp:include>
		<a href="usuario/alta">Dar de alta nuevo usuario</a><br><br>
			<%List<Usuario> listadoUsuarios = (List<Usuario>)request.getAttribute("listadoUsuarios");%>
			<table>
				<th>Id</th><th>Nombre</th><th>Apellidos</th><th>Fecha de nacimiento</th><th>Username</th><th>Opciones</th>
			
				<c:forEach var="ele" items="${listadoUsuarios }">
					<tr>
						<td>${ele.idUsuario }</td>
						<td>${ele.nombre }</td>
						<td>${ele.apellidos }</td>
						<td>${ele.fechaNacimiento }</td>
						<td>${ele.username }</td>
						<td><a href="/usuario/editar/${ele.idUsuario }">Modificar</a> 
						<a href="/usuario/eliminar/${ele.idUsuario }">Borrar</a></td>
					</tr>
				</c:forEach>
			</table>
	</body>
</html>