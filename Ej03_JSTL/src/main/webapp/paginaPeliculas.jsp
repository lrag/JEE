<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List,com.curso.modelo.entidad.Pelicula"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${usuario.idioma}" />
<fmt:bundle basename="i18n/etiquetas">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="app.titulo" /></title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>

<body>

	<div class="text-center page-header">
		<jsp:include page="/WEB-INF/comunes/cabecera.jsp" />
	</div>

	<jsp:include page="/WEB-INF/comunes/menu.jsp" />
	
	<div class="container-fluid">

		<div class="row">

			<div class="col-md-8 offset-md-2">
				<%@include file="/WEB-INF/paginas/peliculas.jsp"%>
			</div>

		</div>
		
	</div>

	<div class="text-center">
		<jsp:include page="/WEB-INF/comunes/pie.jsp" />
	</div>


</body>
	</html>

</fmt:bundle>









