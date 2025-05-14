<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,com.curso.modelo.entidad.Pelicula"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<fmt:setLocale value="${usuario.idioma}"/>    
<fmt:bundle basename="i18n/etiquetas">
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>
		<fmt:message key="app.titulo"/>
	</title>

	<link href="css/estilos.css" type="text/css" rel="stylesheet">

</head>
<body>

	<div class="contenedor">

		<div class="cabecera">
			<jsp:include page="/WEB-INF/comunes/cabecera.jsp"/>
		</div>
		
		<div class="menu">
			<jsp:include page="/WEB-INF/comunes/menu.jsp"/>
		</div>

		<div class="principal">
			<%@include file="/WEB-INF/paginas/gestionPeliculas.jsp"%>
		</div>
		
		<div class="pie">
			<jsp:include page="/WEB-INF/comunes/pie.jsp"/>
		</div>

	</div>

</body>
</html>

</fmt:bundle>









