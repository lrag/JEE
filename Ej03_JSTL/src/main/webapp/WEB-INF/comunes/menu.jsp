<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${usuario.idioma}"/>
<fmt:bundle basename="i18n/etiquetas">

	<div class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <ul class="navbar-nav">
	        <li class="nav-item active">
	            <a class="nav-link" href="#">Películas</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Actores</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Directores</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Salir</a>
	        </li>
	    </ul>
	</div> 

</fmt:bundle>