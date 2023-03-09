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
		<h1>Alta tarjeta</h1>
		<form action="/perfil/tarjeta/alta" method="POST">
			<input type="number" name="numeroTarjeta" placeholder="Número de la tarjeta" required><br><br>
			<input type="text" name="nombre" placeholder="Nombre completo del titular" required><br><br>
			<input type="date" name="fechaCaducidad" placeholder="Fecha de Caducidad" required><br><br>
			<input type="number" name="cvv" placeholder="cvv" required><br><br>
			<input type="submit" value="Dar de alta tarjeta">
		</form>
</body>
</html>