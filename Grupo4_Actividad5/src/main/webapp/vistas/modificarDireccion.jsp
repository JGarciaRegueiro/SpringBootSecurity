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
	<h1>Modificar direccion</h1>
		<form action="/direccion/editar" method="POST">
			<input type="number" name="idDireccion" placeholder="${idDireccion }" value="${idDireccion }" required readonly><br><br>
			<input type="number" name="codigoPostal" placeholder="Código Postal" required><br><br>
			<input type="text" name="localidad" placeholder="Localidad" required><br><br>
			<input type="text" name="calle" placeholder="Nombre de la calle" required><br><br>
			<input type="number" name="numero" placeholder="Número de la calle" required><br><br>
			<input type="number" name="piso" placeholder="Piso" required><br><br>
			<input type="text" name="letra" placeholder="Letra" required><br><br>
			<input type="submit" value="Modificar direccion">
		</form>
	<h1>${mensaje }</h1>
</body>
</html>