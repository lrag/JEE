<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fmt:setLocale value="${usuario.idioma}"/>
<fmt:bundle basename="i18n/etiquetas">

<h2>
	<fmt:message key="peliculas.titulo"/>
</h2>

<form action="SVPeliculas">

	<p class="botonera">
		<input type="submit" name="accion" value="<fmt:message key="btn.nuevo"/>"/>
		<input type="submit" name="accion" value="<fmt:message key="btn.guardar"/>"/>
		<input type="submit" name="accion" value="<fmt:message key="btn.borrar"/>"/>
	</p>

	<input type="hidden" name="idPelicula" value="${pSel.idPelicula}"/>
	
	<table>
		<tr>
			<td><fmt:message key="titulo"/></td>
			<td>
				<input name="titulo" type="text" value="${pSel.titulo}"/>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="director"/></td>
			<td>
				<input name="director" type="text" value="${pSel.director}"/>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="genero"/></td>
			<td>
				<input name="genero" type="text" value="${pSel.genero}"/>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="year"/></td>
			<td>
				<input name="year" type="text" value="${pSel.year}"/>
			</td>
		</tr>
		<tr>
			<td><fmt:message key="observaciones"/></td>
			<td>
				<textarea name="observaciones" rows="3">${pSel.observaciones}</textarea>
			</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<th><fmt:message key="titulo"/></th>			
			<th><fmt:message key="director"/></th>			
			<th><fmt:message key="genero"/></th>			
			<th><fmt:message key="year"/></th>			
		</tr>

		<c:forEach items="${peliculas}" var="p">
			<c:set var="color" value="white"/>
			<c:if test="${p.idPelicula==pSel.idPelicula}">
				<c:set var="color" value="yellow"/>
			</c:if>
			<tr bgcolor="${color}">
				<td>
					<a href="SVPeliculas?accion=seleccionar&idPelicula=${p.idPelicula}">${p.titulo}</a>
				</td>				
				<td>${p.director}</td>				
				<td>${p.genero}</td>				
				<td>${p.year}</td>				
			</tr>
		</c:forEach>
	
	</table>	

</form>
    
</fmt:bundle>
    