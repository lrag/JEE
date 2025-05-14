<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Listado de clientes</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>

<script type="text/javascript" src="js/bootstrap.min.js"></script>

<body>

    <div class="page-header">
    	<marquee>
	        <h1>JSP con scriptlet</h1> 
    	</marquee>
    </div>
    
    <%
    System.out.println("HOLA QUE TAL");
    String txt = "OLA KE TAL";
    out.write(txt);
    %>

</body>
</html>