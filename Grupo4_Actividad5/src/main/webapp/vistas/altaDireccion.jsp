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
			<h1>Alta Direccion</h1>
			<form action="/direccion/alta" method="POST">
				<input type="number" name="codigoPostal" placeholder="C�digo Postal" required><br><br>
				<input type="text" name="localidad" placeholder="Localidad" required><br><br>
				<input type="text" name="calle" placeholder="Nombre de la calle" required><br><br>
				<input type="number" name="numero" placeholder="N�mero de la calle" required><br><br>
				<input type="number" name="piso" placeholder="Piso" required><br><br>
				<input type="text" name="letra" placeholder="Letra" required><br><br>
				<input type="submit" value="Dar de alta tarjeta">
			</form>
		<h1>${mensaje }</h1>
</body>
</html>