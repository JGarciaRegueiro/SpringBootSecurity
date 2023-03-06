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
		<h1>Login</h1>
		<form action="/login" method="POST">
			<input type="email" name="username" placeholder="Email" required><br><br>
			<input type="text" name="pass" placeholder="Contraseña" required><br><br>
			<input type="submit" value="Iniciar sesión">
		</form>
		<h1>${mensaje}</h1>
	</body>
</html>