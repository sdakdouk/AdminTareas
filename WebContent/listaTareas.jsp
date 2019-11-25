<%@page import="modelo.ListaTareas"  import="modelo.Tarea"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://startbootstrap.com/snippets/full-image-header/" type="text/css">
<%@include file = "includes/head.jsp" %>
<link rel="stylesheet" href="css/estilos.css" type="text/css">
</head>
<body>
<div class="container-fluid">

<%@include file = "includes/header.jsp" %>

<%@include file = "includes/nav.jsp" %>

<section>
<div class="row ">
            <div class="col-md-1">
            <a class="nav-link" href="tareas.jsp"><i class="fas fa-ad fa-2x"></i></a></div>
            <div class="col-md-10">
            <h1>Lista de tareas</h1>
            <table class="table table-sm table-bordered shadow" border=1>
<%

	ListaTareas lista = new ListaTareas();
	lista.obtenerTareas();
	String guardar = lista.pintarLista();
%>

<%=guardar %>


</table>
            </div>
            <div class="col-md-1">
            <a class="nav-link" href="tareas.jsp"><i class="fas fa-ad fa-2x"></i></a>
            
            </div>
        </div>






</section>

<%@include file="includes/footer.jsp" %>

</div>

</body>
</html>