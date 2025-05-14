<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.curso.modelo.entidad.Pelicula"%>

<jsp:usebean id="p" class="modelo.Pelicula" scope="page"/>   
<%
Pelicula pBis = new Pelicula();
%>

<jsp:usebean id="p2" class="modelo.Pelicula" scope="page"/>
<jsp:setProperty name="p2" property="titulo" value="Sin perdon"/>
<%
Pelicula p2Bis = new Pelicula();
p2Bis.setTitulo("Sin perdon");
%>

<jsp:usebean id="p3" class="modelo.Pelicula" scope="page"/>
<jsp:setProperty name="p3" property="idPelicula" param="idPelicula"/>
<jsp:setProperty name="p3" property="titulo" param="titulo"/>
<jsp:setProperty name="p3" property="director" param="director"/>
<%
Pelicula p3Bis = new Pelicula();
int idPelicula = 0;
if(request.getParameter("idPelicula")!=null)
	idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
p3Bis.setIdPelicula(idPelicula);
p3Bis.setTitulo(request.getParameter("titulo"));
p3Bis.setDirector(request.getParameter("director"));
%>

<jsp:usebean id="p4" class="modelo.Pelicula" scope="page"/>
<jsp:setProperty name="p4" property="*"/>
<%
int idPelicula2 = 0;
if(request.getParameter("idPelicula")!=null)
	idPelicula2 = Integer.parseInt(request.getParameter("idPelicula"));
String titulo = request.getParameter("titulo");
String director = request.getParameter("director");
String genero = request.getParameter("genero");
int year = 0;
if(request.getParameter("year")!=null)
	year = Integer.parseInt(request.getParameter("year"));
String observaciones = request.getParameter("observaciones");
Pelicula pelicula = new Pelicula(idPelicula2,titulo,director,genero,year,observaciones);
%>

<jsp:usebean id="p5" class="modelo.Pelicula" scope="request"/>
<jsp:setProperty name="p4" property="*"/>
<%
int idPelicula3 = 0;
if(request.getParameter("idPelicula")!=null)
	idPelicula2 = Integer.parseInt(request.getParameter("idPelicula"));
String titulo3 = request.getParameter("titulo");
String director3 = request.getParameter("director");
String genero3 = request.getParameter("genero");
int year3 = 0;
if(request.getParameter("year")!=null)
	year = Integer.parseInt(request.getParameter("year"));
String observaciones3 = request.getParameter("observaciones");
Pelicula pelicula3 = new Pelicula(idPelicula3,titulo3,director3,genero3,year3,observaciones3);
request.setAttribute("p5",pelicula3);
%>

 

    
    
    
    