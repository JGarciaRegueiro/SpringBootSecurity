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
		<h1>Alta producto</h1>
		<form action="/producto/editar" method="POST">
			<input type="number" name="idProducto" placeholder="${idProducto }" value="${idProducto }" required readonly><br><br>
			<input type="text" name="nombre" placeholder="Nombre" required><br><br>
			<input type="text" name="descripcion" placeholder="Descripción" required><br><br>
			<input type="text" name="precio" placeholder="Precio" required><br><br>
			<input type="number" name="stock" placeholder="Cantidades stock" required><br><br>
			<input type="submit" value="Modificar producto">
		</form>
		<h1>${mensaje }</h1>
	</body>
</html>