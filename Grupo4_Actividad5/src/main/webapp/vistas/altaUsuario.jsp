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
		<h1>Alta Usuario</h1>
		<form action="/usuario/alta" method="POST">
			<input type="text" name="nombre" placeholder="Nombre" required><br><br>
			<input type="text" name="apellidos" placeholder="Apellidos" required><br><br>
			<input type="date" name="fechaNacimiento" placeholder="fecha de nacimiento" required><br><br>
			<input type="email" name="username" placeholder="Email" required><br><br>
			<input type="text" name="pass" placeholder="Contraseña" required><br><br>
			<select>
				<option>Cliente</option>
				<option>Administrador</option>
			</select><br><br>
			<input type="submit" value="Dar de alta usuario">
		</form>
		<h1>${mensaje }</h1>
</body>
</html>