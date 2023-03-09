<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import="java.util.List"%>
<%@page import="com.grupo4.tienda.entities.Usuario"%>
<%@page import="com.grupo4.tienda.entities.Tarjeta"%>
<%@page import="com.grupo4.tienda.entities.Direccion"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="inicio.jsp"></jsp:include>
		<h1>Perfil</h1>
		<%Usuario usuario = (Usuario)request.getAttribute("usuario");%>
			<table>
				<th>Id</th><th>Nombre</th><th>Apellidos</th><th>Fecha nacimiento</th><th>Fecha registro</th><th>username</th>
				<tr>
					<td>${usuario.idUsuario }</td>
					<td>${usuario.nombre }</td>
					<td>${usuario.apellidos }</td>
					<td>${usuario.fechaNacimiento }</td>
					<td>${usuario.fechaRegistro }</td>
					<td>${usuario.username }</td>
				</tr>
			</table>
		<h1>Mis tarjetas</h1>
			<a href="/perfil/tarjeta/alta">Dar de alta nueva tarjeta</a>
			<%List<Tarjeta> listadoTarjetas = (List<Tarjeta>)request.getAttribute("listadoTarjetas");%>
			<table>
				<th>Id</th><th>Numero</th><th>Nombre</th><th>Fecha de caducidad</th><th>CVV</th><th>Opciones</th>
			
				<c:forEach var="ele" items="${listadoTarjetas }">
					<tr>
						<td>${ele.idTarjeta }</td>
						<td>${ele.numeroTarjeta }</td>
						<td>${ele.nombre }</td>
						<td>${ele.fechaCaducidad }</td>
						<td>${ele.cvv }</td>
						<td><a href="/perfil/tarjeta/editar/${ele.idTarjeta }">Modificar</a> 
						<a href="/perfil/tarjeta/eliminar/${ele.idTarjeta }">Borrar</a></td></td>
					</tr>
				</c:forEach>
			</table>
		<h1>Mis direcciones</h1>
			<a href="/perfil/direccion/alta">Añadir una dirección</a>
			<%List<Direccion> listadoDirecciones = (List<Direccion>)request.getAttribute("listadoDirecciones");%>
			<table>
				<th>Id</th><th>Codigo postal</th><th>Localidad</th><th>Calle</th><th>Número</th><th>Piso</th><th>Letra</th><th>Opciones</th>
			
				<c:forEach var="ele" items="${listadoDirecciones }">
					<tr>
						<td>${ele.idDireccion }</td>
						<td>${ele.codigoPostal }</td>
						<td>${ele.localidad }</td>
						<td>${ele.calle }</td>
						<td>${ele.numero }</td>
						<td>${ele.piso }</td>
						<td>${ele.letra }</td>
						<td><a href="/perfil/direccion/editar/${ele.idDireccion }">Modificar</a> 
						<a href="/perfil/direccion/eliminar/${ele.idDireccion }">Borrar</a></td>
					</tr>
				</c:forEach>
			</table>
</html>