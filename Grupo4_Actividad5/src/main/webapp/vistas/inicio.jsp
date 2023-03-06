<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<header>
			<nav>
			<a href="/inicio">Inicio</a>
				<sec:authorize access="hasRole('ROLE_ADMINISTRADOR')">
					<a href="/producto">Productos</a>
					<a href="/usuario">Usuarios</a>
				</sec:authorize>
				<a href="/categorias">Categorías</a>
				<a href="/login">Iniciar sesión</a>
				<a href="/registro">Registrarse</a>
				<a href="/perfil">Mi perfil</a>
				<sec:authorize access="isAuthenticated()">
					<a href="/carrito">Carrito</a>
				</sec:authorize>
			</nav>
		</header>
		<sec:authorize access="isAuthenticated()">
    		<h1>Bienvenid@, <sec:authentication property="name"/></h1>
		</sec:authorize>
	</body>
</html>