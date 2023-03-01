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
		<h1>Registro</h1>
		<form action="/registro" method="POST">
			<input type="text" name="nombre" placeholder="Nombre" required><br><br>
			<input type="text" name="apellidos" placeholder="Apellidos" required><br><br>
			<input type="date" name="fechaNacimiento" placeholder="fecha de nacimiento" required><br><br>
			<input type="email" name="username" placeholder="Email" required><br><br>
			<input type="text" name="pass" placeholder="Contraseña" required><br><br>
			<input type="submit" value="Registrarme">
		</form>
	</body>
</html>