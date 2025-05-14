<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.curso.modelo.entidad.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<%
//Usuario usr = (Usuario) session.getAttribute("usuario");
//out.println(usr.getIdioma());
//${usuario.nombre}
%>

<fmt:setLocale value="${usuario.idioma}"/>
<fmt:bundle basename="i18n/etiquetas">

<script>

function enviar(accion){
	document.getElementById("accion").value = accion
	document.getElementById("formulario").submit()
}

window.onload = function(){
	btnNuevo.onclick = function(){
			document.getElementById("formulario").reset()
		}
	btnGuardar.onclick = function(){
			enviar("guardar")
		}
	btnBorrar.onclick = function(){
			enviar("borrar")
		}	
}

</script>

<h2 class="text-center">
	<fmt:message key="peliculas.titulo"/>
</h2>

<form id="formulario" action="SVPeliculas" method="post">

	<div class="text-center"> 
		<input type="button" id="btnNuevo"   class="btn btn-primary m-1" value="<fmt:message key="btn.nuevo"/>"/>
		<input type="button" id="btnGuardar" class="btn btn-primary m-1" value="<fmt:message key="btn.guardar"/>"/>
		<input type="button" id="btnBorrar"  class="btn btn-danger  m-1" value="<fmt:message key="btn.borrar"/>"/>
	</div>

	<input type="hidden" id="accion" name="accion"/>
	<input type="hidden" name="idPelicula" value="${pSel.idPelicula}"/>
	
	<div class="row">
	    <div class="col-sm-12 col-md-2 mt-1">
	        <label for="titulo"><fmt:message key="titulo"/></label>
	    </div>
	    <div class="col-sm-12 col-md-10 mt-1">
			<input name="titulo" type="text" value="${pSel.titulo}" class="form-control"/>
	    </div>
	    
	    <div class="col-sm-12 col-md-2 mt-1">
	        <label for="director"><fmt:message key="director"/></label>
	    </div>
	    <div class="col-sm-12 col-md-10 mt-1">
			<input name="director" type="text" value="${pSel.director}" class="form-control"/>
	    </div>
	    
	    <div class="col-sm-12 col-md-2 mt-1">
	        <label for="genero"><fmt:message key="genero"/></label>
	    </div>
	    <div class="col-sm-12 col-md-10 mt-1">
			<input name="genero" type="text" value="${pSel.genero}" class="form-control"/>
	    </div>
	    
	    <div class="col-sm-12 col-md-2 mt-1">
	        <label for="year"><fmt:message key="year"/></label>
	    </div>
	    <div class="col-sm-12 col-md-10 mt-1">
			<input name="year" type="text" value="${pSel.year}" class="form-control"/>
	    </div>
	    
	    <div class="col-sm-12 col-md-2 mt-1">
	        <label for="observaciones"><fmt:message key="observaciones"/></label>
	    </div>
	    <div class="col-sm-12 col-md-10 mt-1">
			<textarea name="observaciones" type="text" class="form-control">${pSel.observaciones}</textarea>
	    </div>
	    
	</div>	
	
	<table class="table table-hover table-striped">  
		<thead>
			<tr>
				<th><fmt:message key="titulo"/></th>			
				<th><fmt:message key="director"/></th>			
				<th><fmt:message key="genero"/></th>			
				<th><fmt:message key="year"/></th>			
			</tr>
		</thead>
		
		<tbody>
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
		</tbody>	
	</table>	

</form>
    
</fmt:bundle>
    