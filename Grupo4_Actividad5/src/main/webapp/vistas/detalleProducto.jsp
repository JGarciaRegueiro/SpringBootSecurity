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
		<h1>Producto</h1>
		
		<%List<Producto> productos = (List<Producto>)request.getAttribute("productos");%>
			<table border="1">
				<tr>
					<th>Id</th>
					<th>Descripción</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Stock</th>
					
				</tr>
		<% for (Producto ele: productos){%>
			<tr>
				<td><%= ele.getIdProducto() %></td>
				<td><%= ele.getDescripción() %></td>
				<td><%= ele.getNombre() %></td>
				<td><%= ele.getPrecio() %></td>
				<td><%= ele.getStock() %></td>
				
			</tr>
		<%} %>
	</table>
</body>
</html>