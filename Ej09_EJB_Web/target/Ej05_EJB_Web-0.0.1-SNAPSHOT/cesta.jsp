<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<form action="SVCesta" method="POST">
			Producto:
			<input type="text" name="producto"/>
			<input type="submit" value="Añadir"/>
		</form>
	</div>

	<table align="center" border="1">
		<tr>
			<th>Producto</th>
		</tr>
		<c:forEach var="p" items="${cesta}">
			<tr>
				<td>${p}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>