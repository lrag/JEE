<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, com.curso.modelo.entidad.*, com.curso.modelo.negocio.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">
		<font color="orange">
			Listado de incidencias
		</font>
	</h1>

	<table align="center" border="1">
		<tr>
			<th>Descripción</th>
			<th>Empleado</th>
			<th>Estado</th>
		</tr>		
		<%
		ServicioIncidencias servicioIncidencias = new ServicioIncidencias();	
		List<Incidencia> incidencias = servicioIncidencias.listar();
		for(Incidencia i: incidencias){
		%>
		 	<tr>
		 		<td>
		 			<%out.println(i.getDescripcion());%>
		 			<%=i.getDescripcion()%>
		 		</td>
		 		<td><%=i.getEmpleado()%></td>
		 		<td><%=i.getEstado()%></td>
		 	</tr>
		<%			
		}
		%>
	</table>

</body>
</html>





