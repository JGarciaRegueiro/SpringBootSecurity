<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<jsp:include page="inicio.jsp"></jsp:include>
	<h1>Modificar tarjeta</h1>
		<form action="/tarjeta/modificar" method="POST">
			<input type="number" name="idTarjeta" placeholder="${idTarjeta }" value="${idTarjeta }" required readonly><br><br>
			<input type="number" name="numeroTarjeta" placeholder="Número de la tarjeta" required><br><br>
			<input type="text" name="nombre" placeholder="Nombre completo del titular" required><br><br>
			<input type="date" name="fechaCaducidad" placeholder="Fecha de Caducidad" required><br><br>
			<input type="number" name="cvv" placeholder="cvv" required><br><br>
			<input type="submit" value="Dar de alta tarjeta">
		</form>
	<h1>${mensaje }</h1>

</body>
</html>