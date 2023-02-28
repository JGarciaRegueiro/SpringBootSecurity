<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<a href="/categorias">Categorías</a>
				<a href="/login">Iniciar sesión</a>
				<a href="/registro">Registrarse</a>
				<a href="/perfil">Mi perfil</a>
				<a href="/carrito">Carrito</a>
			</nav>
		</header>
		<h1>Login</h1>
		<form action="/login" method="POST">
			<input type="email" name="email" placeholder="Email" required><br><br>
			<input type="text" name="pass" placeholder="Contraseña" required><br><br>
			<input type="submit" value="Iniciar sesión">
		</form>
		<h1>${mensaje}</h1>
	</body>
</html>