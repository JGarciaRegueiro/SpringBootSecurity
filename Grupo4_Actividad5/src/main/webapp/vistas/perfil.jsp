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
		<h1>Perfil</h1>
		<h1>Mis tarjetas</h1>
			<a href="/perfil/tarjeta/alta">Dar de alta nueva tarjeta</a>
			<table>
				<th><td>Tarjeta</td></th>
				<th><td><a href="/perfil/tarjeta/modificar/{id}">Modificar</a></td></th>
				<th><td><a href="/perfil/tarjeta/eliminar/{id}">Eliminar</a></td></th>
			</table>
		<h1>Mis direcciones</h1>
	</body>
</html>